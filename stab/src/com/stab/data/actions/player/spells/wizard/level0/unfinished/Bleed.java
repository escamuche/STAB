package com.stab.data.actions.player.spells.wizard.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Bleed extends SpellOnTarget{
	
	public static final String ID="BLEED_WIZARD";

	public Bleed() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(6);
	     setTargetClass(PhysicalToken.class);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Bleed");
	     this.setEffectType(DEBUFF);
		}

	@Override
	public boolean affect(Info instigator, Info receptor) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		return false;
	}
}
