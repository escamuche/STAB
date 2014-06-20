package com.stab.data.actions.traps;

import java.awt.Point;

import com.stab.data.animation.BasicSparkAnimation;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.request.basic.ActionRequest;

public class FlameJet extends Action  {

	public static final String ID="FLAMEJET_ACTION";
	
	public FlameJet() {
		setRange(3);
		setAoE(true);
		setTargetMode(Action.TILE);
	}

	@Override
	public int affect(Info instigator, Info target, Point point, ActionRequest ar) {
		if (target instanceof BaseInfo){
			Damage f=new RolledDamage(2,4,Damage.FIRE_DAMAGE,instigator);
			((BaseInfo)target).apply(f);
		}
		return OK;
	}

	@Override
	public int getAreaType() {
		return AoE.LINE;	
	}

	@Override
	public float getLength(Info caster) {
		return 3;
	}

	@Override
	public float getWidth(Info caster) {
		return 1;
	}

	@Override
	public int getRequiredLine() {
		return LOS;
	}

	@Override
	public boolean affectsSelf() {
		return false;
	}

	
	@Override
	public void playExecuteActionAnimation(Info caster, Info target,
			Point pos, ActionRequest ar) {

		super.playExecuteActionAnimation(caster, target, pos, ar);
		caster.playSound("flames");
		caster.playAnimation(BasicSparkAnimation.ID,"PARTICLE#generic/flamejet",1500,Math.toDegrees(getAngle(caster, target, pos)));
	}
	
}
