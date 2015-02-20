package com.stab.data.actions.traps;

import java.awt.Point;

import com.stab.data.animation.SwingAtAnimation;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.info.applicable.SavingThrowEffect;
import com.stab.pf.utils.PathfinderUtils;

public class WallScythe extends Action  {

	public static final String ID="WALLBLADE_ACTION";
	
	public WallScythe() {
		setRange(3);
		setAoE(true);
		setTargetMode(Action.TILE);
		setAPCost(0);
	}

	@Override
	public int affect(Info instigator, Info target, Point point, ActionRequest ar) {
		if (target instanceof BaseInfo){
			Damage f=new RolledDamage(3,6,Damage.SLASHING_DAMAGE,instigator);
			SavingThrowEffect s=PathfinderUtils.createST_Half(null, (BaseInfo)target, StabConstants.REFLEXSAVE, 15, f);
			((BaseInfo)target).apply(s);
		
		}
		return OK;
	}

	@Override
	public int getAreaType() {
		return AoE.COLUMN;	
	}

	@Override
	public float getLength(Info caster) {
		return 1f;
	}

	@Override
	public float getWidth(Info caster) {
		return 1;
	}

	@Override
	public int getRequiredLine() {
		return IN_SIGHT;
	}

	@Override
	public boolean affectsSelf() {
		return false;
	}

	
	@Override
	public int affectTile(Point tile, Info instigator, Info target,Point point,ActionRequest ar){
			
		//	instigator.playAnimationAt(GenericSpriteAnimation.ID,tile,SpecialEffectsSpriteFactory.DAZED);
			return super.affectTile(tile, instigator, target, point, ar);
	}
	
	@Override
	public void playExecuteActionAnimation(Info caster, Info target,
			Point pos, ActionRequest ar) {

		super.playExecuteActionAnimation(caster, target, pos, ar);
		caster.playSound("effects/SwipeTarget");
		
		caster.playAnimationAt(SwingAtAnimation.ID,pos,"effects/wallBlade");
	}
}
