package com.stab.data.actions.player.spells.cleric.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.ResistanceBuff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class ResistanceCleric extends SpellOnTarget{
	
	public static final String ID="RESISTANCE_CLERIC";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Bufado = (BaseInfo)target;
		
		ResistanceBuff buff = new ResistanceBuff(Bufado);
		Bufado.addTrait(buff);
		
		return true;
		}
	
	public ResistanceCleric() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/nightshield");
     setName("Resistance");
     this.setEffectType(BUFF);
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
}