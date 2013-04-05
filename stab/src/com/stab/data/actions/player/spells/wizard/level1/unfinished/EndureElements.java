package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;


public class EndureElements extends SpellOnSelf{
	public static final String ID="ENDUREELEMENTS_WIZARD";

	public EndureElements() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("EndureElements");
	     this.setEffectType(BUFF);
		}



	@Override
	public boolean affect(Info instigator,Info receive) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		return false;
	}
}