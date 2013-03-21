package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
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
	public boolean execute(BaseInfo arg0) {
		//EntropicShield_Buff = new EntropicShield_Buff();
		return false;
	}

	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}