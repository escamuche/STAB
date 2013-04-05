package com.stab.data.actions.player.spells.wizard.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;


public class DetectPoison extends SpellOnSelf{
	public static final String ID="DETECTPOISON_WIZARD";

	public DetectPoison() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("DetectPoison");
	     this.setEffectType(BUFF);
		}



	@Override
	public boolean affect(Info instigator,Info receive) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		return false;
	}
}
