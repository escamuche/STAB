package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Sleep extends SpellOnTile{

	public static final String ID="SLEEP";
	
	public Sleep() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(22);
	     setResource("actions/sleep");
	     setName("Sleep");
	     this.setEffectType(DEBUFF);
		}


	@Override
	public boolean affect(Info instigator,Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receptor;
		return false;
	}
}
