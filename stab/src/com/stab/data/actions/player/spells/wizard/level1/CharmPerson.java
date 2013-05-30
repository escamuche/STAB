package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.CharmPerson_Debuff;
import com.stab.model.info.BaseInfo;

public class CharmPerson extends SpellOnTarget{
	
	public static final String ID="CHARMPERSON";
	
@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	int cl = getCasterLevel(caster);
	int time = cl*60;
	

	CharmPerson_Debuff debuff = new CharmPerson_Debuff();
	debuff.setTime(time);
	target.addTrait(debuff);
	return super.fullEffect(caster, target, point);
}
	
	public CharmPerson() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setSave(StabConstants.WILLSAVE);
		setResource("actions/charmperson");
		setName("CharmPerson");
		this.setEffectType(DEBUFF);
		setRange(CLOSE);
		this.setDescription("This charm makes a humanoid creature regard you as its trusted friend and ally (treat the target's attitude as friendly). If the creature is currently being threatened or attacked by you or your allies, however, it receives a +5 bonus on its saving throw.");
	}
}
