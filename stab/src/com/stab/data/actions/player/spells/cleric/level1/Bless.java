package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.Bless_Buff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Bless extends SpellOnTarget{
	
	public static final String ID="BLESS";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo atacado = (BaseInfo)target;
		BaseInfo caster = (BaseInfo)yo;
		int cl=caster.getValue(StabConstants.CASTERLEVEL);
		
		Bless_Buff buff = new Bless_Buff();
		buff.setTime(cl*10);
		atacado.addTrait(buff);
		
		return true;
		}
	
	public Bless() {
     setRange(4);
     setTargetClass(PhysicalToken.class);
     setResource("actions/bless");
     setName("Bless");
     this.setCasterClass(StabConstants.CLERICCASTER);
     this.setEffectType(BUFF);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 10;
	}
	

}