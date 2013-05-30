package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.EnlargePerson_Buff;
import com.stab.model.info.BaseInfo;

public class EnlargePerson extends SpellOnTarget {
	
	public static final String ID="ENLARGEPERSON";
	
	public EnlargePerson() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setResource("actions/enlargeperson");
		setName("EnlargePerson");
		this.setEffectType(BUFF);
		setRange(TOUCH);
		setDescription("This spell causes instant growth of a humanoid creature, doubling its height and multiplying its weight by 8. This increase changes the creature's size category to the next larger one. The target gains a +2 size bonus to Strength, a –2 size penalty to Dexterity (to a minimum of 1), and a –1 penalty on attack rolls and AC due to its increased size.");
	}

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		EnlargePerson_Buff buff = new EnlargePerson_Buff();
		buff.setTime(getCasterLevel(caster)*10);
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}
}
