package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;


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
	public boolean execute(BaseInfo arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
