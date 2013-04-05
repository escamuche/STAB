package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;


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
	public boolean affect(Info instigator,Info receive) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		return false;
	}
}