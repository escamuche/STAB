package com.stab.data.info.debuff;

import com.stab.data.StabConstants;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Doom_Debuff extends Buff {

	public static final String ID="DOOM_DEBUFF";
	
	public Doom_Debuff() {
	
		
		this.setAnimIcon("actions/doom");				
		this.setSound("HolyCast");
		this.setResource("actions/doom");                  
		this.setName("Doom");
	
		Modifier tohit=new Modifier(StabConstants.TOHIT, -2);
		Modifier tohitranged=new Modifier(StabConstants.TOHITRANGED, -2);
		Modifier damage=new Modifier(StabConstants.DAMAGE, -2);
		Modifier damageranged=new Modifier(StabConstants.DAMAGERANGED, -2);
		Modifier savef=new Modifier(StabConstants.FORTITUDESAVE, -2);
		Modifier saver=new Modifier(StabConstants.REFLEXSAVE, -2);
		Modifier savew=new Modifier(StabConstants.WILLSAVE, -2);
		
		addTrait(tohit);
		addTrait(tohitranged);
		addTrait(damage);
		addTrait(damageranged);
		addTrait(savef);
		addTrait(saver);
		addTrait(savew);
	}
}
