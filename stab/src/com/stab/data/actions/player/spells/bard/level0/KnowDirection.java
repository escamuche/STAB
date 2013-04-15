package com.stab.data.actions.player.spells.bard.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.Info;

public class KnowDirection extends SpellOnSelf{

	public static final String ID="KNOWDIRECTION";
	
	public KnowDirection() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.BARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Know Direction");
	     this.setEffectType(SPECIAL);
		}


	@Override
	public boolean affect(Info instigator, Info target,Point point) {
		// TODO Auto-generated method stub
		return false;
	}
}
