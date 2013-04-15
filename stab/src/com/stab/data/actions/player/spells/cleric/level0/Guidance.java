package com.stab.data.actions.player.spells.cleric.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.Guidance_Buff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Guidance extends SpellOnTarget{
	
	public static final String ID="GUIDANCE";

	@Override
	public boolean affect(Info instigator, Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		Guidance_Buff buff = new Guidance_Buff();
		buff.setTime(10);
		target.addTrait(buff);
		return true;
	
	}
	
	public Guidance() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/flare");
		setName("Guidance");
		this.setEffectType(BUFF);
		this.setRange(TOUCH);
		
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
	
}