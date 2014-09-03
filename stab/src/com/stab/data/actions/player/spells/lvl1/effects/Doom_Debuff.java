package com.stab.data.actions.player.spells.lvl1.effects;

import com.stab.data.actions.player.spells.Spell;
import com.stab.data.info.debuff.condition.ShakenCondition;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.model.info.BaseInfo;

public class Doom_Debuff extends SpellEffect {

	public static final String ID="DOOM_DEBUFF";
	
	public Doom_Debuff(Spell spell,BaseInfo caster) {
		super(spell,caster);
		setBuffDebuff(DEBUFF);
		addTrait(new ShakenCondition());
		setEvident(true);
	}
}
