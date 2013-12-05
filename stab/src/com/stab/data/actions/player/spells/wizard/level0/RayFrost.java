package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class RayFrost extends SpellOnTarget{
	
	public static final String ID="RAYFROST";

	
	
	


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