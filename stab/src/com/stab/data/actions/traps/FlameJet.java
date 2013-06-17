package com.stab.data.actions.traps;

import java.awt.Point;

import com.stab.data.animation.BasicSparkAnimation;
import com.stab.data.info.applicable.RolledDamage;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.action.TileAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class FlameJet extends Action implements TileAction,AoE{

	public static final String ID="FLAMEJET_ACTION";
	
	public FlameJet() {
		setRange(3);
		setTargetInfoClass(BaseInfo.class);
	}

	@Override
	public boolean affect(Info instigator, Info target, Point point) {
		if (target instanceof BaseInfo){
			Damage f=new RolledDamage(2,4,Damage.FIRE_DAMAGE,instigator);
			((BaseInfo)target).apply(f);
		}
		return true;
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
	protected void playExecuteActionAnimation(Info caster, Info target,
			Point pos) {

		super.playExecuteActionAnimation(caster, target, pos);
		caster.playSound("flames");
		caster.playAnimation(BasicSparkAnimation.ID,"PARTICLE#generic/flamejet",1500,Math.toDegrees(getAngle(caster, target, pos)));
	}
	
}
