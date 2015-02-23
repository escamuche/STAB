package com.stab.data.actions.monster;

import java.awt.Point;

import com.stab.data.animation.GenericProyectileAnimation;
import com.stab.data.animation.sprite.SpecialEffectsSpriteFactory;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.actions.PathfinderAction;

public class AcidFlask extends PathfinderAction {
	
	
	public static final String ID="ACIDFLASK_ACTION";

	
	public AcidFlask() {
		setEffectType(DAMAGE);
		setTargetMode(Action.TILE);
		setAoE(true);
		this.setName("Acid flask");
		this.setResource("actions/acidsplash");
		this.setRange(5);
		this.setLosType(IN_SIGHT);
	//	this.setLosType(IN_RANGE);
	//	setRelations(Action.TARGET_ENEMY);
	}
	
	
	@Override
	public int getAreaType() {
		return AoE.BURST;
	}

	@Override
	public float getLength(Info caster) {
		return 1.5f;
	}

	@Override
	public float getWidth(Info caster) {
		return 0;
	}

	@Override
	public int getRequiredLine() {
		return IN_RANGE;
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
	public void playExecuteActionAnimation(Info caster, Info target,	Point pos, ActionRequest ar) {
		super.playExecuteActionAnimation(caster, target, pos, ar);
		
	//	target.playAnimationOnTile(BasicSparkAnimation.ID,"PARTICLE#spells/swirl");
		caster.playAnimationAt(GenericProyectileAnimation.ID,pos,SpecialEffectsSpriteFactory.ACID_FLASK,caster.getWidth());
		//target.playSound("effects/Curse");
	}
	
	
}
