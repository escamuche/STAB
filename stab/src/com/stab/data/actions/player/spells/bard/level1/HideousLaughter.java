package com.stab.data.actions.player.spells.bard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.Info;

public class HideousLaughter extends SpellOnTarget{

	public static final String ID="HIDEOUSLAUGHTER";
	
	public HideousLaughter() {
		
		 setLevel(1);
		 setCasterClass(StabConstants.BARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Hideous Laughter");
	     this.setEffectType(SPECIAL);
	     
		}


	@Override
	public boolean affect(Info arg0, Info arg1) {
		// TODO Auto-generated method stub
		return false;
	}
}