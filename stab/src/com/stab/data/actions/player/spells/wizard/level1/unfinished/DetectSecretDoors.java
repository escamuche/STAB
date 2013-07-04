package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;


public class DetectSecretDoors extends SpellOnSelf{
	
	public static final String ID="DETECTSECRETDOORS";

	public DetectSecretDoors() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("DetectSecretDoors");
	     this.setEffectType(BUFF);
		}



	
}
