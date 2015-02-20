package com.stab.pf.info.debuff.condition;

import com.stab.common.Constants;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DebuffEffect;
import com.stab.pf.StabConstants;

public class FatiguedCondition extends DebuffEffect {

	public static final String ID="FATIGUEDCONDITION_DEBUFF";
	
	public FatiguedCondition() {
		
		this.setName("Fatigued");
		
		Modifier str = new Modifier(StabConstants.STRENGHT,-2);
		Modifier dex = new Modifier(StabConstants.DEXTERITY,-2);
		
		addTrait(str);
		addTrait(dex);
		
		//falta no correr ni cargar
	}
	
	@Override
	protected Sprite createEffectSprite() {
		DecorToken t=createEffectToken(null,Constants.EFFECTS);
		t.setResource("PARTICLE#effects/fatigued");
		return t;
	}
	
	
}
