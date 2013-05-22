package com.stab.data.actions.player.spells.bard.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.Info;

public class Lullaby extends SpellOnTarget{

	public static final String ID="LULLABY";
	
	public Lullaby() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.BARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Lullaby");
	     this.setEffectType(SPECIAL);
	     this.setDescription("Any creature within the area that fails a Will save becomes drowsy and inattentive, taking a -5 penalty on Perception checks and a -2 penalty on Will saves against  sleep effects while the lullaby is in effect. Lullaby lasts for as long as the caster concentrates, plus up to 1 round per caster level thereafter.");
	    
	}


	@Override
	public boolean affect(Info instigator, Info target,Point point) {
		// TODO Auto-generated method stub
		return false;
	}
}
