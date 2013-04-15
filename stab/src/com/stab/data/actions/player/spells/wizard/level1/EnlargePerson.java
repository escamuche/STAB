package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.EnlargePerson_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class EnlargePerson extends SpellOnTarget {
	
	public static final String ID="ENLARGEPERSON";
	
	public EnlargePerson() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setResource("actions/enlargeperson");
		setName("EnlargePerson");
		this.setEffectType(BUFF);
		setRange(TOUCH);
	}

	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		
		EnlargePerson_Buff buff = new EnlargePerson_Buff();
		buff.setTime(getCasterLevel(caster)*10);
		target.addTrait(buff);
		return true;
	}
}
