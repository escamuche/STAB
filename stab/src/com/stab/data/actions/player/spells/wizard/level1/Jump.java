package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.Jump_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Jump extends SpellOnTarget {
	
	public static final String ID="JUMP";
	
	public Jump() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setResource("actions/jump");
		setName("Jump");
		this.setEffectType(BUFF);
	}

	@Override
	public boolean affect(Info instigator,Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receptor;
		int cl= getCasterLevel(caster);
		
	
		Jump_Buff buff = new Jump_Buff(cl);
		
		buff.setTime(cl*10);
		
		target.addTrait(buff);
		
		return true;
	}


}
