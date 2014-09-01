package com.stab.data.actions.player.spells.lvl1.effects;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.Spell;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Shield_Buff extends SpellEffect implements Buff{//implements Attends<SpellActionEffect>{

	public static final String ID="SHIELD_BUFF";
	
	public Shield_Buff(Spell spell,BaseInfo caster) {
		super(spell,caster);
		setEvident(false);
		Modifier ca=new Modifier(StabConstants.SHIELDDEFENSE,StabConstants.SHIELDMOD,+4);
		addTrait(ca);
		setEffectResource("SHADER#blueshield#effects/globe2$S");
		}
/*
	@Override
	public void attend(SpellActionEffect eff) {
		eff.setResult(Applicable.NEUTRALIZED);
	}

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof SpellActionEffect){
			if(SpellActionEffect)
		}
		return false;
	}

/**/

}