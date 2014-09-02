package com.stab.data.actions.player.spells.lvl1.effects;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.Spell;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;

public class RayEnfeeblement_Debuff extends SpellEffect {

	public static final String ID="RAYENFEEBLEMENT_DEBUFF";
	
	public RayEnfeeblement_Debuff(Spell spell,BaseInfo caster,int amount) {
		super(spell,caster);
		setEvident(true);
		this.setSound("effects/curse");
		setBuffDebuff(DEBUFF);
		Modifier str=new Modifier(StabConstants.STRENGHT,ID, -amount);
		addTrait(str);
		setEffectResource("PARTICLE#effects/purpleEye");
	
	}
}
