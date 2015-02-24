package com.stab.base.actions.traps;

import java.awt.Point;
import java.util.Random;

import com.stab.client.animation.BasicSparkAnimationAt;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.info.base.FloorDecoration;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.info.applicable.SavingThrowEffect;
import com.stab.pf.utils.PathfinderUtils;

public class CaveIn extends Action  {

	public static final String ID="CAVEIN_ACTION";
	
	
	static String[] res={"decor/smallrocks1","decor/smallrocks1","decor/smallrocks1"};
	
	public CaveIn() {
		setRange(3);
		setAoE(true);
		setTargetMode(Action.TILE);
		setAPCost(0);
	}

	@Override
	public int affect(Info instigator, Info target, Point point, ActionRequest ar) {
		if (target instanceof BaseInfo){
			Damage f=new RolledDamage(3,6,Damage.IMPACT_DAMAGE,instigator);
			SavingThrowEffect s=PathfinderUtils.createST_Half((BaseInfo)instigator, (BaseInfo)target, StabConstants.REFLEXSAVE, 15, f);
			((BaseInfo)target).apply(s);
		}
		return OK;
	}

	@Override
	public int getAreaType() {
		return AoE.BURST;	
	}

	@Override
	public float getLength(Info caster) {
		return 1;
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
		caster.playSound("effects/crumble");
		caster.playAnimationAt(BasicSparkAnimationAt.ID,pos,"PARTICLE#effects/crumble");
		
	}
	
	
	public int affectTile(Point tile, Info instigator, Info target, Point point, ActionRequest ar) {
	
		if (new Random().nextInt(5)==1){
			//Crear decoracion de derrumbamiento.
			FloorDecoration d=(FloorDecoration)instigator.getEntityManager().createElement(FloorDecoration.ID);
			d.setPos(tile);
			d.setSize(1,1);
			d.setResource(res[new Random().nextInt(res.length)]); 
			instigator.getScene().add(d);
		}		
		return super.affectTile(tile, instigator, target, point, ar);
	}
	
}
