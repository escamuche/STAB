package com.stab.adventure.everflame;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Attack;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.request.basic.ActionRequest;

public class PillarArrowsAction extends Action  {

	public static final String ID="PILLARARROWS_ACTION";
	
	public PillarArrowsAction() {
		setRange(6);
		setAoE(true);
		setTargetMode(SELF);
		setAPCost(0);
	}

	@Override
	public int affect(Info instigator, Info target, Point point, ActionRequest ar) {
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
		return OK;
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
