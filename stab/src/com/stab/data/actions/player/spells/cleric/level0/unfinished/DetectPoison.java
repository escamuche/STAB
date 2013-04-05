package com.stab.data.actions.player.spells.cleric.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;


public class DetectPoison extends SpellOnSelf{
	public static final String ID="DETECTPOISON_CLERIC";

	public DetectPoison() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.CLERICCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("DetectPoison");
	     this.setEffectType(BUFF);
		}



	@Override
	public boolean affect(Info instigator,Info target) {
		BaseInfo self=(BaseInfo)target;
		return false;
	}
}
