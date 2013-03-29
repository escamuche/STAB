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
	public boolean execute(Info caster, Info target) {
		
		BaseInfo d = (BaseInfo) target;
		BaseInfo self = (BaseInfo) caster;
		int cl = getCasterLevel(self);
		int time = cl*60;
		

		CharmPerson_Debuff debuff = new CharmPerson_Debuff();
		debuff.setTime(time);
		d.addTrait(debuff);
		return true;
		}
	
	public CharmPerson() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/charmperson");
		setName("CharmPerson");
		this.setEffectType(DEBUFF);
		setRange(CLOSE);
	
	}
}
