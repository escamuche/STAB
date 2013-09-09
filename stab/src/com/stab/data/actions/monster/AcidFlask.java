package com.stab.data.actions.monster;

import java.awt.Point;

import com.stab.data.animation.BasicSparkAnimation;
import com.stab.data.info.applicable.RolledDamage;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.action.TileAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.request.basic.ActionRequest;

public class AcidFlask extends Action implements TileAction, AoE{
	
	
	public static final String ID="ACIDFLASK_ACTION";

	
	public AcidFlask() {
		setEffectType(DAMAGE);
		this.setName("Acid glob");
		this.setResource("actions/acidsplash");
	}
	
	
	@Override
	public int getAreaType() {
		return AoE.BURST;
	}

	@Override
	public float getLength(Info caster) {
		return 2;
	}

	@Override
	public float getWidth(Info caster) {
		return 0;
	}

	@Override
	public int getRequiredLine() {
		return LOS;
	}

	@Override
	public boolean affectsSelf() {
		return true;
	}

	@Override
	public int affect(Info instigator, Info target, Point point, ActionRequest ar) {
		if (target instanceof BaseInfo){
			Damage d= new RolledDamage(1,6,Damage.ACID_DAMAGE,instigator);
			((BaseInfo)target).apply(d);
			
		}
		return OK;
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 6;
	}

	@Override
	public int getEffectSubType(Info instigator, Info target) {
		return Damage.ACID_DAMAGE;
	}
	
	@Override
	protected void playExecuteActionAnimation(Info caster, Info target,	Point pos, ActionRequest ar) {
		super.playExecuteActionAnimation(caster, target, pos, ar);
		
	//	target.playAnimationOnTile(BasicSparkAnimation.ID,"PARTICLE#spells/swirl");
	
		target.playSound("effects/Curse");
	}
	
	
}
