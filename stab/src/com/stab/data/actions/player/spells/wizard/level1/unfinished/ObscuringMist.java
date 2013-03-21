package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.Info;

public class ObscuringMist extends SpellOnTile{

	public static final String ID="OBSCURINGMIST_WIZARD";
	
	public ObscuringMist() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(4);
	     setResource("actions/obscuringmist");
	     setName("ObscuringMist");
	     this.setEffectType(SPECIAL);
		}


	@Override
	public boolean execute(Info arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}
}
