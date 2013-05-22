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
	     setDescription("When you cast this spell, you instantly know the direction of north from your current position. The spell is effective in any environment in which “north” exists, but it may not work in extraplanar settings. Your knowledge of north is correct at the moment of casting, but you can get lost again within moments if you don't find some external reference point to help you keep track of direction.");
		}


	@Override
	public boolean affect(Info instigator, Info target,Point point) {
		// TODO Auto-generated method stub
		return false;
	}
}
