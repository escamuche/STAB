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
		
		BaseInfo caster=(BaseInfo)yo;
		this.setRangeTouch(caster);
		BaseInfo Bufado = (BaseInfo)target;
		Guidance_Buff buff = new Guidance_Buff();
		buff.setTime(10);
		Bufado.addTrait(buff);
		return true;
	
	}
	
	public Guidance() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/flare");
		setName("Guidance");
		this.setEffectType(BUFF);
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
	
}