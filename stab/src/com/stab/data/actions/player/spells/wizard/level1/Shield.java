package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.Shield_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

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
	public boolean affect(Info instigator,Info receive) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		
		Shield_Buff buff = new Shield_Buff();
		buff.setTime(getCasterLevel(caster)*10);
		target.addTrait(buff);
		
		return true;
	}
}
	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/