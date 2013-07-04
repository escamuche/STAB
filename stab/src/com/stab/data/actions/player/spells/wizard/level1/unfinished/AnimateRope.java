package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class AnimateRope extends SpellOnTile{

	public static final String ID="ANIMATEROPE";
	
	public AnimateRope() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(MEDIUM);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Animate Rope");
	     this.setEffectType(DEBUFF);
		}


	
}