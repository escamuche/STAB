package com.stab.data.actions.player.spells.cleric.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.ResistanceBuff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class ResistanceCleric extends SpellOnTarget{
	
	public static final String ID="RESISTANCE_CLERIC";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Bufado = (BaseInfo)target;
		BaseInfo caster=(BaseInfo)yo;
		
		ResistanceBuff buff = new ResistanceBuff();
		buff.setTime(10);
		Bufado.addTrait(buff);
		
		return true;
		}
	
	public ResistanceCleric() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/nightshield");
		setName("Resistance");
		this.setEffectType(BUFF);
		this.setRange(TOUCH);
		
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
}