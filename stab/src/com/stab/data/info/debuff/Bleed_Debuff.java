package com.stab.data.info.debuff;

import com.stab.data.StabConstants;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Bleed_Debuff extends Buff {

	public static final String ID="BLEED_DEBUFF";
	
	public Bleed_Debuff(BaseInfo atacado) {
	
		
		this.setAnimIcon("actions/bleed");				
		this.setSound("HolyCast");
		this.setResource("actions/bleed");                  
		this.setName("Bleed");
		
		atacado.playAnimationOn(ShootProyectileAnimation.ID, atacado.getToken(), "PARTICLE#magicmissile");
	}
}