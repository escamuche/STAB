package com.stab.data.actions.player.spells.bard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.Info;

public class MagicMouth extends SpellOnTile{

	public static final String ID="MAGICMOUTH";
	
	public MagicMouth() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.BARDCASTER);
		 setRange(CLOSE);
	     setResource("actions/hypnotism");
	     setName("Magic Mouth");
		}


	@Override
	public boolean execute(Info arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}
}