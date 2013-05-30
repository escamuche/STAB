package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.Jump_Buff;
import com.stab.model.info.BaseInfo;

public class Jump extends SpellOnTarget {
	
	public static final String ID="JUMP";
	
	public Jump() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setResource("actions/jump");
		setName("Jump");
		this.setEffectType(BUFF);
		this.setDescription("The subject gets a +10 enhancement bonus on Acrobatics checks made to attempt high jumps or long jumps. The enhancement bonus increases to +20 at caster level 5th, and to +30 (the maximum) at caster level 9th.");
	}

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		int cl= getCasterLevel(caster);
		
		
		Jump_Buff buff = new Jump_Buff(cl);
		
		buff.setTime(cl*10);
		
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}

}
