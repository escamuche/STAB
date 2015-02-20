package com.stab.pf.actions.player.spells.lvl1.effects;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.Spell;
import com.stab.pf.info.spellcasting.SpellEffect;

public class Shield_Buff extends SpellEffect {//implements Attends<SpellActionEffect>{

	public static final String ID="SHIELD_BUFF";
	
	public Shield_Buff(Spell spell,BaseInfo caster) {
		super(spell,caster);
		setBuffDebuff(BUFF);
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