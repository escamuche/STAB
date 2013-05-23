package com.stab.data.actions.traps;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.info.applicable.Attack;
import com.stab.data.info.applicable.RolledDamage;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class PillarArrowsAction extends Action implements SelfAction,AoE{

	public static final String ID="PILLARARROWS_ACTION";
	
	public PillarArrowsAction() {
		setRange(6);
		setTargetInfoClass(BaseInfo.class);
	}

	@Override
	public boolean affect(Info instigator, Info target, Point point) {
		if (target instanceof BaseInfo){
			int n = Roll.d4();
			while(n>0){
				Attack a = null;
				a.setTarget((BaseInfo) target);
				a.addApplicable(new RolledDamage(1,8,Damage.IMPACT_DAMAGE,instigator));
				((BaseInfo)target).apply(a);
			n=n-1;
			}
		}
		return true;
	}

	@Override
	public int getAreaType() {
		return AoE.BURST;	
	}

	@Override
	public float getLength(Info caster) {
		return 6;
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
		return false;
	}

	
}