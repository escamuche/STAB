package com.stab.data.actions.player.spells.bard.level1;

import java.awt.Point;

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
	public boolean affect(Info instigator, Info target,Point point) {
		// TODO Auto-generated method stub
		return false;
	}
}