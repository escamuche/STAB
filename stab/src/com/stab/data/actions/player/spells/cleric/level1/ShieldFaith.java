package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.ShieldFaith_Buff;
import com.stab.model.info.BaseInfo;

public class ShieldFaith extends SpellOnSelf{
	
	public static final String ID="SHIELDFAITH";
	
	public ShieldFaith() {
     setResource("actions/shieldfaith");
     setName("Shield of Faith");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
	}

	@Override
	public boolean execute(BaseInfo yo) {
		
		BaseInfo caster = (BaseInfo)yo;
		ShieldFaith_Buff buff = new ShieldFaith_Buff();
		buff.setTime(getCasterLevel(caster)*10);
		caster.addTrait(buff);
		
		return true;
	}
}