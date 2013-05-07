package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.MageArmor_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class MageArmor extends SpellOnTarget{
	
	public static final String ID="MageArmor";

	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
	
		MageArmor_Buff buff = new MageArmor_Buff();
		buff.setTime(getCasterLevel(caster)*600);
		target.addTrait(buff);
		
		return true;
		}
	
	public MageArmor() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		
		setResource("actions/magearmor");
		setName("MageArmor");
		setEffectType(BUFF);
		setRange(TOUCH);
	}
}