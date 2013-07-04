package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Hypnotism extends SpellOnTile{

	public static final String ID="HYPNOTISM";
	
	public Hypnotism() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(6);
	     setResource("actions/hypnotism");
	     setName("Hypnotism");
	     this.setEffectType(DEBUFF);
		}



}
