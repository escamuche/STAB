package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.DoorToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Door;

public class OpenClose extends SpellOnTarget{
	
	public static final String ID="OPENCLOSE";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo caster = (BaseInfo)yo;
		int cl = getCasterLevel(caster);
		
		
		Door Atacado = (Door)target;
		Atacado.infoInteracts(yo);
		return true;
	}
	
	public OpenClose() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(DoorToken.class);
		setResource("actions/openclose");
		setName("Open/Close");
		this.setEffectType(BUFF);
		setRange(CLOSE);
	}
}
