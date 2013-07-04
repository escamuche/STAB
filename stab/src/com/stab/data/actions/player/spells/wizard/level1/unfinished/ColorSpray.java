package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class ColorSpray extends SpellOnTile{

	public static final String ID="COLORSPRAY";
	
	public ColorSpray() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(1);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("ColorSpray");
	     this.setEffectType(DEBUFF);
		}


	
}
