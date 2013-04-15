package com.stab.data.actions.player.spells.bard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.Info;

public class LesserConfusion extends SpellOnTarget{

	public static final String ID="LESSERCONFUSION";
	
	public LesserConfusion() {
		
		 setLevel(1);
		 setCasterClass(StabConstants.BARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Lesser Confusion");
	     this.setEffectType(SPECIAL);
	     
		}


	@Override
	public boolean affect(Info instigator, Info target,Point point) {
		// TODO Auto-generated method stub
		return false;
	}
}
