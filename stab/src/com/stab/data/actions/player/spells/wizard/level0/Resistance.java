package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.ResistanceBuff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Resistance extends SpellOnTarget{
	
	public static final String ID="Resistance";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Bufado = (BaseInfo)target;
		
		ResistanceBuff buff = new ResistanceBuff(Bufado);
		Bufado.addTrait(buff);
		
		return true;
		}
	
	public Resistance() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/resistance");
     setName("Resistance");
     this.setEffectType(BUFF);
	}
}