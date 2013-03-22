package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.CharmPerson_Debuff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class CharmPerson extends SpellOnTarget{
	
	public static final String ID="CHARMPERSON";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo d = (BaseInfo) target;
		CharmPerson_Debuff debuff = new CharmPerson_Debuff(d);
		debuff.setTime(60);
		d.addTrait(debuff);
		return true;
		}
	
	public CharmPerson() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/charmperson");
     setName("CharmPerson");
     this.setEffectType(DEBUFF);
	}
}
