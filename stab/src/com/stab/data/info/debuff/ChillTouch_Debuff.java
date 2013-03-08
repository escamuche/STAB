package com.stab.data.info.debuff;

import com.stab.data.StabConstants;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class ChillTouch_Debuff extends Buff {

	public static final String ID="CHILDTOUCH_DEBUFF";
	
	public ChillTouch_Debuff(BaseInfo atacado) {
	
		this.setAnimIcon("actions/chilltouch");				
		this.setSound("HolyCast");
		this.setResource("actions/childtouch");                  
		this.setName("ChildTouch");
		
		this.setPermanent();
		atacado.playAnimationOn(ShootProyectileAnimation.ID, atacado.getToken(), "PARTICLE#magicmissile");
	
		Modifier tohit=Modifier.createMod(StabConstants.STRENGHT, -1);
		addTrait(tohit);
	}
}
