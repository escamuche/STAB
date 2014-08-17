package com.stab.data.info.other;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import com.stab.data.info.debuff.condition.UnableToActCondition;
import com.stab.model.basic.Sprite;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.model.info.trait.base.activity.CoopActivity;
import com.stab.util.StabUtils;

public class PathfinderActivity extends CoopActivity{

	String skill;
	int bonus;
	ArrayList<Info> coops;
	boolean onlyOnce=true;
	int dc;
	boolean continuous;
	
	public PathfinderActivity(String skill,int dc) {
		this.skill=skill;
		bonus=0;
		this.dc=dc;
		coops= new ArrayList<Info>();
		this.setMaxProgress(2);
		continuous=false;
	}
	
	
	@Override
	protected void configureEffectSprite(Sprite es) {
		super.configureEffectSprite(es);
		es.playAnimation(VisualEffect.TINKER_ANIMATION);
	}
	
	public boolean isOnlyOnce() {
		return onlyOnce;
	}
	public void setOnlyOnce(boolean onlyOnce) {
		this.onlyOnce = onlyOnce;
	}
	
	
	@Override
	protected void infoSupports(Info instigator) {
		if (coops.contains(instigator))
			return;
		super.infoSupports(instigator);
		if (isOnlyOnce())
			coops.add(instigator);
		if (!(instigator instanceof BaseInfo))
			return;
		SkillRoll sk=StabUtils.getGameLogic().getSkillRoll((BaseInfo)instigator, skill, 15);
		sk.check();
		if (sk.success())
			coopSuccess(sk,instigator);
		else
			coopFails(sk,instigator);
	}


	protected void coopFails(SkillRoll sk,Info instigator) {
		if (sk.isBotch()){
			bonus=bonus-2;
			instigator.showFloatingText("Botch! -2", Color.red);
			return;
		}
		instigator.showFloatingText("Support fail", Color.yellow);
	}


	protected void coopSuccess(SkillRoll sk,Info instigator) {
		bonus=bonus+2;
		instigator.showFloatingText("Support +2", Color.green);
	}
	
	
	@Override
	protected void finishActivity() {
		SkillRoll sk=StabUtils.getGameLogic().getSkillRoll((BaseInfo)getTarget(), skill, dc);
		sk.addModifier(bonus);
		sk.check();
		if (sk.success()){
			success(sk);
			super.finishActivity();
		}else{
			fails(sk);
			cancelActivity();
		}
	}


	protected void fails(SkillRoll sk) {
		getTarget().playAnimation(VisualEffect.FAILURE_ANIMATION);
	}


	protected void success(SkillRoll sk) {
		getTarget().playAnimation(VisualEffect.SUCCESS_ANIMATION);
	}
	
	public void setContinuous(boolean continuous) {
		this.continuous = continuous;
	}
	
	public boolean isContinuous() {
		return continuous;
	}
	
	@Override
	public void advanceActivity() {
		if (isContinuous())
			if (getTarget().hasTrait(UnableToActCondition.class)){
				cancelActivity();
				return;
			}	
		super.advanceActivity();
	}
	
}
