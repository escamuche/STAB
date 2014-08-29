package com.stab.data.actions.player.spells.lvl0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.trait.Modifier;

public class Resistance extends SpellOnTarget{
	
	public static final String ID="RESISTANCE";
	public static final String BUFF_ID="RESISTANCE_BUFF";

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		SpellEffect buff= new SpellEffect(getSpell(),caster);
		buff.setId(BUFF_ID);
		Modifier fortsave=new Modifier(StabConstants.FORTITUDESAVE,StabConstants.RESISTANCEMOD,+1);
		Modifier refsave=new Modifier(StabConstants.REFLEXSAVE,StabConstants.RESISTANCEMOD, +1);
		Modifier willsave=new Modifier(StabConstants.WILLSAVE,StabConstants.RESISTANCEMOD, +1);
	
		buff.addTrait(fortsave);
		buff.addTrait(refsave);
		buff.addTrait(willsave);
		
	
		buff.setTime(10);
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}
	
	public Resistance() {
		setLevel(0);
		setResource("actions/nightshield");
		setName("Resistance");
		this.setEffectType(BUFF);
		setDuration(FIXED);
		this.setDescriptors(EffectDescriptor.ABJURATION);
		this.setRange(TOUCH);
		this.setDescription("You imbue the subject with magical energy that protects it from harm, granting it a +1 resistance bonus on saves." +
				"Resistance can be made permanent with a permanency spell.");
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 3;
	}
}