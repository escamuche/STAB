package com.stab.data.actions.player.spells.bard.level0;

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
		}


	@Override
	public boolean affect(Info arg0, Info arg1) {
		// TODO Auto-generated method stub
		return false;
	}
}
