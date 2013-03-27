package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.EntropicShield_Buff;
import com.stab.model.info.BaseInfo;

public class EntropicShield extends SpellOnSelf{
	
	public static final String ID="ENTROPICSHIELD";

	
	public EntropicShield() {
     setRange(1);
     setResource("actions/bless");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("Entropic Shield");
     this.setEffectType(BUFF);
	}


	@Override
	public boolean execute(BaseInfo caster) {
		
			EntropicShield_Buff buff = new EntropicShield_Buff();
			buff.setTime(caster.getValue(StabConstants.CASTERLEVEL)*10);
			caster.addTrait(buff);
			return true;
	
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
	

}