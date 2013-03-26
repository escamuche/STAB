package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.Sanctuary_Buff;
import com.stab.model.info.BaseInfo;

public class Sanctuary extends SpellOnSelf{
	
	public static final String ID="SANCTUARY";
	
	public Sanctuary() {
     setResource("actions/divinefavor");
     setName("Sanctuary");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
	}

	@Override
	public boolean execute(BaseInfo yo) {
		
		BaseInfo caster = (BaseInfo)yo;
		Sanctuary_Buff buff = new Sanctuary_Buff();
		caster.addTrait(buff);
		
		return true;
	}
}
