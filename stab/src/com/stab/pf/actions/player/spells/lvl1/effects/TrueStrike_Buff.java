package com.stab.pf.actions.player.spells.lvl1.effects;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.ListensTo;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.Spell;
import com.stab.pf.info.spellcasting.SpellEffect;

//TODO: falta la parte de ignorar concealment
//Y añadir algun efecto especial al ataque, claro

public class TrueStrike_Buff extends SpellEffect implements ListensTo<WeaponAttack>{

	public static final String ID="TRUESTRIKE_BUFF";
	
	public TrueStrike_Buff(Spell spell,BaseInfo caster) {
		super(spell,caster);
		setBuffDebuff(BUFF);
		setEvident(false);
		Modifier hit=new Modifier(StabConstants.TOHIT,StabConstants.INSIGHTMOD,+20);
		Modifier hitranged=new Modifier(StabConstants.TOHITRANGED,StabConstants.INSIGHTMOD,+20);
		addTrait(hit);
		addTrait(hitranged);
		setTime(2);
	}

	@Override
	public boolean interestedIn(Info instigator, BaseInfo target, Applicable a) {
		if (a instanceof WeaponAttack && instigator==this.getTarget())
			return true;
		return false;
	}

	@Override
	public boolean applied(Info instigator, BaseInfo target, Applicable a) {
		this.end();
		return true;
	}
}