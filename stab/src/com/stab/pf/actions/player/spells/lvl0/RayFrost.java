package com.stab.pf.actions.player.spells.lvl0;

import java.awt.Point;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTarget;

public class RayFrost extends SpellOnTarget{
	
	public static final String ID="RAYFROST";

	
	
	@Override
	public int execute(Info origin, Info target, Point point, ActionRequest ar) {
		// TODO Auto-generated method stub
		return super.execute(origin, target, point, ar);
	}


	public RayFrost() {
		
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setResource("actions/niaccoldray");
		setName("RayFrost");
		this.setEffectType(DAMAGE);
		setRange(CLOSE);
		setMedium(RAY);
		setWeapon(RayFrost.ID);
		this.setDescription("A ray of freezing air and ice projects from your pointing finger. You must succeed on a ranged touch attack with the ray to deal damage to a target. The ray deals 1d3 points of cold damage.");
		this.setDescriptors(EffectDescriptor.EVOCATION,EffectDescriptor.COLD);
	}

	@Override
	public int getEffectSubType(Info instigator, Info target) {
		return Damage.COLD_DAMAGE;
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 3;
	}
	

}