package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.info.applicable.WillAttack;
import com.stab.data.info.debuff.Doom_Debuff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.data.actions.player.spells.SpellOnTarget;

public class Doom extends SpellOnTarget {
	
	public static final String ID="DOOM";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacado = (BaseInfo)target;
		WillAttack ataque = new WillAttack(Atacado);
		if(ataque.hits()) {
			Doom_Debuff debuff = new Doom_Debuff(Atacado);
			Atacado.addTrait(debuff);
			return true;
			}
		return false;
		}
	
	public Doom() {
     setRange(22);
     setTargetClass(PhysicalToken.class);
     setResource("actions/doom");
     setName("Doom");
     this.setEffectType(DEBUFF);
	}

	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}
