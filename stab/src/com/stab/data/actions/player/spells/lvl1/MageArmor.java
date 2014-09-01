package com.stab.data.actions.player.spells.lvl1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;

public class MageArmor extends SpellOnTarget{
	
	public static final String ID="MAGEARMOR";
	public static final String BUFF_ID="MAGEARMOR_BUFF";

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		
		SpellEffect buff= new SpellEffect(getSpell(),caster);
		buff.setBuffDebuff(BUFF);
		buff.setId(BUFF_ID);
		buff.setEvident(true);
		buff.setEffectResource("PARTICLE#spells/magearmor");
		Modifier ca=new Modifier(StabConstants.ARMORDEFENSE,StabConstants.ARMORMOD,+4);
		buff.addTrait(ca);
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}
	
	public MageArmor() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setDescriptors(EffectDescriptor.CONJURATION,EffectDescriptor.CREATION,EffectDescriptor.FORCE);
		setResource("actions/magearmor");
		setName("MageArmor");
		setEffectType(BUFF);
		setDuration(LONG);
		setRange(TOUCH);
		this.setDescription("An invisible but tangible field of force surrounds the subject of a mage armor spell, providing a +4 armor bonus to AC.");
	}
}