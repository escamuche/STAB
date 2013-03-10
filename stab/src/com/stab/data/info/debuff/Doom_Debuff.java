package com.stab.data.info.debuff;

import com.stab.data.StabConstants;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Doom_Debuff extends Buff {

	public static final String ID="DOOM_DEBUFF";
	
	public Doom_Debuff(BaseInfo atacado) {
	
		
		this.setAnimIcon("actions/doom");				
		this.setSound("HolyCast");
		this.setResource("actions/doom");                  
		this.setName("Doom");
		
		this.setTime(10);
		atacado.playAnimationOn(ShootProyectileAnimation.ID, atacado.getToken(), "PARTICLE#magicmissile");
	
		Modifier tohit=Modifier.createMod(StabConstants.TOHIT, -2);
		Modifier tohitranged=Modifier.createMod(StabConstants.TOHITRANGED, -2);
		Modifier damage=Modifier.createMod(StabConstants.DAMAGE, -2);
		Modifier damageranged=Modifier.createMod(StabConstants.DAMAGERANGED, -2);
		Modifier savef=Modifier.createMod(StabConstants.FORTITUDESAVE, -2);
		Modifier saver=Modifier.createMod(StabConstants.REFLEXSAVE, -2);
		Modifier savew=Modifier.createMod(StabConstants.WILLSAVE, -2);
		
		addTrait(tohit);
		addTrait(tohitranged);
		addTrait(damage);
		addTrait(damageranged);
		addTrait(savef);
		addTrait(saver);
		addTrait(savew);
	}
}
