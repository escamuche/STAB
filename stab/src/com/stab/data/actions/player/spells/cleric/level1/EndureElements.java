package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;


public class EndureElements extends SpellOnSelf{
	public static final String ID="ENDUREELEMENTS_CLERIC";

	public EndureElements() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.CLERICCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Endure Elements");
	     this.setEffectType(BUFF);
		}



	@Override
	public boolean execute(BaseInfo arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}