package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.applicable.magic.WillAttack;
import com.stab.data.info.debuff.Doom_Debuff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Doom extends SpellOnTarget {
	
	public static final String ID="DOOM";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo atacado = (BaseInfo)target;
		BaseInfo caster = (BaseInfo)yo;
		int cl=caster.getValue(StabConstants.CASTERLEVEL);
		
		WillAttack ataque = new WillAttack(atacado);
		if(ataque.hits()) {
			Doom_Debuff debuff = new Doom_Debuff();
			debuff.setTime(cl*10);
			atacado.addTrait(debuff);
			return true;
			}
		return false;
		}
	
	public Doom() {
     setRange(22);
     setTargetClass(PhysicalToken.class);
     setResource("actions/doom");
     setName("Doom");
     this.setCasterClass(StabConstants.CLERICCASTER);
     this.setEffectType(DEBUFF);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 10;
	}
	

}
