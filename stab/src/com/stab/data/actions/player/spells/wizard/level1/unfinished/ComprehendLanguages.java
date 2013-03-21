package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;


public class ComprehendLanguages extends SpellOnSelf{
	public static final String ID="COMPREHENDLANGUAGES";

	public ComprehendLanguages() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("ComprehendLanguages");
	     this.setEffectType(BUFF);
		}



	@Override
	public boolean execute(BaseInfo arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
