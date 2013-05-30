package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.MageArmor_Buff;
import com.stab.model.info.BaseInfo;

public class MageArmor extends SpellOnTarget{
	
	public static final String ID="MageArmor";

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		MageArmor_Buff buff = new MageArmor_Buff();
		buff.setTime(getCasterLevel(caster)*600);
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}
	
	public MageArmor() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		
		setResource("actions/magearmor");
		setName("MageArmor");
		setEffectType(BUFF);
		setRange(TOUCH);
		this.setDescription("An invisible but tangible field of force surrounds the subject of a mage armor spell, providing a +4 armor bonus to AC.");
	}
}