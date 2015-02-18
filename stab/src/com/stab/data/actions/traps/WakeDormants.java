package com.stab.data.actions.traps;

import java.awt.Point;

import com.stab.data.animation.BasicSparkAnimationAt;
import com.stab.data.animation.ShockwaveAnimation;
import com.stab.data.info.props.DormantInfo;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class WakeDormants extends Action  {

	public static final String ID="WAKE_ACTION";

	public WakeDormants() {
	
		setAoE(true);
		setRange(5);
		setAoE(true);
		setTargetMode(Action.TILE);
		setAPCost(0);
		
	}
	@Override
	public int getRequiredLine() {
		return IN_RANGE;
	}

	@Override
	public boolean affectsSelf() {
		return false;
	}

	
	@Override
	public void playExecuteActionAnimation(Info caster, Info target,
			Point pos, ActionRequest ar) {

		super.playExecuteActionAnimation(caster, target, pos, ar);
		caster.playSound("effects/ShadowCast");
		caster.playAnimationAt(ShockwaveAnimation.ID,pos,5);
		
	}
	@Override
	public int getAreaType() {
		return AoE.BURST;	
	}

	@Override
	public float getLength(Info caster) {
		return 5;
	}
	
	@Override
	public int affect(Info instigator, Info target, Point point,
			ActionRequest ar) {
		if (target instanceof DormantInfo)
			((DormantInfo)target).wakeup();
		return 0;
	}
	

}
