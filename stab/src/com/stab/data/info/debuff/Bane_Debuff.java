package com.stab.data.info.debuff;

import com.stab.data.StabConstants;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Bane_Debuff extends Buff {

	public static final String ID="BANE_DEBUFF";
	
	public Bane_Debuff(BaseInfo atacado) {
	
		
		this.setAnimIcon("actions/bane");				
		this.setSound("HolyCast");
		this.setResource("actions/bane");                  
		this.setName("Bane");
		
		this.setTime(10);
		atacado.playAnimationOn(ShootProyectileAnimation.ID, atacado.getToken(), "PARTICLE#magicmissile");
	
		Modifier tohit=new Modifier(StabConstants.TOHIT, -1);
		//falta el -1 contra miedo
		addTrait(tohit);
	}
}