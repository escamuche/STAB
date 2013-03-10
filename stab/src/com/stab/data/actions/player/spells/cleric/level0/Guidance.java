package com.stab.data.actions.player.spells.cleric.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.Guidance_Buff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Guidance extends SpellOnTarget{
	
	public static final String ID="GUIDANCE";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo bufado = new BaseInfo();
		Guidance_Buff buff = new Guidance_Buff((BaseInfo) target);
		bufado.addTrait(buff);
		return true;
	
	}
	
	public Guidance() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/flare");
     setName("Guidance");
     this.setEffectType(BUFF);
	}
}