package com.stab.data.actions.player.spells;

import com.stab.data.info.buff.Shield_Buff;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Shield extends TargetAction{
	
	public static final String ID="Shield";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo caster = (BaseInfo)yo;
		
		Shield_Buff buff = new Shield_Buff(caster);
		caster.addTrait(buff);
		
		return true;
		}
	
	public Shield() {
     //setRange(4);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_shaman_watershield");
     setName("Shield");
     this.setEffectType(BUFF);
	}
}
	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/