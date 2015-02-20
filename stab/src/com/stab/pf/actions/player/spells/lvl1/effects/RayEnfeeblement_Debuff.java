package com.stab.pf.actions.player.spells.lvl1.effects;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.Spell;
import com.stab.pf.info.spellcasting.SpellEffect;

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
