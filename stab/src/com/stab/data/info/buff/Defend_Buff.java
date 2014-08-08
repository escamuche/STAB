package com.stab.data.info.buff;

import com.stab.common.Constants;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;

public class Defend_Buff extends BuffEffect {
	
	public static final String ID="DEFEND_BUFF";
	
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
	protected Sprite createEffectSprite() {
		DecorToken t=createEffectToken("defending",Constants.EFFECTS);
	
		return t;
	}

}
