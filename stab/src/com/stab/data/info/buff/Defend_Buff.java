package com.stab.data.info.buff;

import com.stab.common.Constants;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Defend_Buff extends Buff {
	
	public static final String ID="RAGE_BUFF";
	
	public Defend_Buff() {
	
		Modifier masdosalaCA= new Modifier("CA", +2);  // Creamos un modificador de +2 a la ca
		this.addTrait(masdosalaCA);
		this.setTime(1);
		this.setAnimIcon("actions/ability_warrior_defensivestance");				
		this.setSound("HolyCast");
		this.setResource("actions/ability_warrior_defensivestance");                  
		this.setName("Defending");
		this.setUnique(true);
	}
	
	@Override
	protected DecorToken createEffectToken() {
		DecorToken t=createEffectToken("defending",Constants.EFFECTS);
	
		return t;
	}

}
