package com.stab.pf.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.model.info.BaseInfo;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnSelf;
import com.stab.pf.info.buff.spells.Identify_Buff;

public class Identify extends SpellOnSelf{
	
	public static final String ID="IDENTIFY";
	
	public Identify() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setRange(1);
     setResource("actions/ability_druid_naturalperfection");
     setName("Identify");
     this.setEffectType(BUFF);
     this.setDescription("This spell functions as detect magic, except that it gives you a +10 enhancement bonus on Spellcraft checks made to identify the properties and command words of magic items in your possession. This spell does not allow you to identify artifacts.");
	}

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		Identify_Buff buff = new Identify_Buff();
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}
}
