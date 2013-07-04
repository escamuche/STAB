package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class SilentImage extends SpellOnTile{

	public static final String ID="SILENTIMAGE";
	
	public SilentImage() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(88);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("SilentImage");
	     this.setEffectType(SPECIAL);
		}



}