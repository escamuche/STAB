package com.stab.pf.actions.player.spells.lvl1.effects;

import com.stab.model.info.BaseInfo;
import com.stab.pf.actions.player.spells.Spell;
import com.stab.pf.info.debuff.condition.ShakenCondition;
import com.stab.pf.info.spellcasting.SpellEffect;

public class Doom_Debuff extends SpellEffect {

	public static final String ID="DOOM_DEBUFF";
	
	public Doom_Debuff(Spell spell,BaseInfo caster) {
		super(spell,caster);
		setBuffDebuff(DEBUFF);
		addTrait(new ShakenCondition());
		setEvident(true);
	}
}
