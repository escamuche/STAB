package com.stab.data.actions.player.spells.cleric.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;

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




}