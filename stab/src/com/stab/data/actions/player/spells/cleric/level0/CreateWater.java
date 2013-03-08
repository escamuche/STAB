package com.stab.data.actions.player.spells.cleric.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.Info;

public class CreateWater extends SpellOnTile{
	
	public static final String ID="CREATEWATER";

	public CreateWater() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.CLERICCASTER);
		 setRange(6);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("CreateWater");
	     this.setEffectType(SPECIAL);
		}

	@Override
	public boolean execute(Info arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}


}