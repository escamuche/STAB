package com.stab.data.actions.player.spells.lvl0.effects;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.player.spells.Spell;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.Modifier;

public class Lullaby_Debuff extends SpellEffect implements Attends<SavingThrowEffect> {
	
	public static final String ID="LULLABY_DEBUFF";
	
	public Lullaby_Debuff(Spell spell, Info caster) {
		super(spell, caster);
		this.setAnimIcon("actions/lullaby");				
		this.setSound("HolyCast");
		this.setResource("actions/lullaby");                  
		this.setName("Lullaby");
		setEvident(true);
		setEffectResource("PARTICLE#spells/lullaby");
		Modifier a=new Modifier(StabConstants.PERCEPTION, -5);
		addTrait(a);
	}

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof SavingThrowEffect)
			if (((SavingThrowEffect)a).getDescriptors().contains(EffectDescriptor.SLEEP))
				return true;
		return false;
	}

	@Override
	public void attend(SavingThrowEffect app) {
		((SavingThrowEffect)app).addModifier(-2);
	}
}
