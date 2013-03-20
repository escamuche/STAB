package com.stab.data.info.debuff;

import com.stab.data.StabConstants;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Flare_Debuff extends Buff {

	public static final String ID="FLARE_DEBUFF";
	
	public Flare_Debuff(BaseInfo atacado) {
	
		
		this.setAnimIcon("actions/flare");				
		this.setSound("HolyCast");
		this.setResource("actions/flare");                  
		this.setName("Flare");
		
		this.setTime(10);
		atacado.playAnimationOn(ShootProyectileAnimation.ID, atacado.getToken(), "PARTICLE#magicmissile");
	
		Modifier tohit=new Modifier(StabConstants.TOHIT, -1);
		addTrait(tohit);
	}
}