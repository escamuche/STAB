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
		
		MageArmor_Buff buff = new MageArmor_Buff(caster);
		caster.addTrait(buff);
		
		return true;
		}
	
	public MageArmor() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_shaman_watershield");
     setName("MageArmor");
     this.setEffectType(BUFF);
	}
}