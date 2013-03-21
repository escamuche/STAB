package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.Bane_Debuff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Bane extends SpellOnTarget {
	
	public static final String ID="BANE";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacado = (BaseInfo)target;
		
		Bane_Debuff debuff = new Bane_Debuff(Atacado);
		Atacado.addTrait(debuff);
		
		return true;
		}
	
	public Bane() {
     setRange(10);
     setTargetClass(PhysicalToken.class);
     setResource("actions/bane");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("Bane");
     this.setEffectType(DEBUFF);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
	

}
