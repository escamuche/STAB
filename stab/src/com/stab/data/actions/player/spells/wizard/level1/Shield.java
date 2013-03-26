package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.Shield_Buff;
import com.stab.model.info.BaseInfo;

public class Shield extends SpellOnSelf{
	
	public static final String ID="Shield";
	
	public Shield() {
     //setRange(4);
     setResource("actions/shield");
     setName("Shield");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.WIZARDCASTER);
	}

	@Override
	public boolean execute(BaseInfo yo) {
		
		BaseInfo caster = (BaseInfo)yo;
		Shield_Buff buff = new Shield_Buff();
		caster.addTrait(buff);
		
		return true;
	}
}
	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/