package com.stab.data.actions.player.spells.cleric.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.ResistanceBuff;
import com.stab.model.info.BaseInfo;

public class Resistance extends SpellOnTarget{
	
	public static final String ID="RESISTANCE_CLERIC";

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		ResistanceBuff buff = new ResistanceBuff();
		buff.setTime(10);
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}
	
	public Resistance() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
		
		setResource("actions/nightshield");
		setName("Resistance");
		this.setEffectType(BUFF);
		this.setRange(TOUCH);
		this.setDescription("You imbue the subject with magical energy that protects it from harm, granting it a +1 resistance bonus on saves." +
				"Resistance can be made permanent with a permanency spell.");
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
}