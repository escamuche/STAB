package com.stab.data.actions.player.spells.cleric.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.Bleed_Debuff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Bleed extends SpellOnTarget{
	
	public static final String ID="BLEED_CLERIC";

	public Bleed() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.CLERICCASTER);
		 setRange(5);
	     setTargetClass(PhysicalToken.class);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Bleed");
	     this.setEffectType(DEBUFF);
		}

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Debufed = (BaseInfo)target;
		
		Bleed_Debuff debuff = new Bleed_Debuff(Debufed);
		Debufed.addTrait(debuff);
		
		return true;
	}
}
