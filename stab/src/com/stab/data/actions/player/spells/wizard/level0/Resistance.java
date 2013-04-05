package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.ResistanceBuff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Resistance extends SpellOnTarget{
	
	public static final String ID="RESISTANCE";

	@Override
	public boolean affect(Info instigator, Info receptor) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		ResistanceBuff buff = new ResistanceBuff();
		buff.setTime(10);
		target.addTrait(buff);
		
		return true;
		}
	
	public Resistance() {
		
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/nightshield");
		setName("Resistance");
		this.setEffectType(BUFF);
		setRange(TOUCH);
	}
}