package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.Info;

public class BurningHands extends SpellOnTile{

	public static final String ID="BURNINGHANDS";
	
	public BurningHands() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(1);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("bURNINGhANDS");
	     this.setEffectType(DAMAGE);
		}


	@Override
	public boolean execute(Info arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}
}