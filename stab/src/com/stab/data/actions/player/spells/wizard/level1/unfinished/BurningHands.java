package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.Info;

public class BurningHands extends SpellOnTile{

	public static final String ID="BURNINGHANDS";
	
	public BurningHands() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(1);
	     setResource("actions/burninghands");
	     setName("BurningHands");
	     this.setEffectType(DAMAGE);
		}


	@Override
	public boolean execute(Info arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}
}
