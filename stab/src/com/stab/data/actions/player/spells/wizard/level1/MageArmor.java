package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.MageArmor_Buff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class MageArmor extends SpellOnTarget{
	
	public static final String ID="MageArmor";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo caster = (BaseInfo)yo;
		
	
		MageArmor_Buff buff = new MageArmor_Buff();
		buff.setTime(getCasterLevel(caster)*600);
		caster.addTrait(buff);
		
		return true;
		}
	
	public MageArmor() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/magearmor");
		setName("MageArmor");
		setEffectType(BUFF);
		setRange(TOUCH);
	}
}