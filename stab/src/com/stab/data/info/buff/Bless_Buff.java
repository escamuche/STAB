package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Bless_Buff extends Buff {

	public static final String ID="BLESS_BUFF";
	
	public Bless_Buff(BaseInfo atacado) {
	
		
		this.setAnimIcon("actions/bless");				
		this.setSound("HolyCast");
		this.setResource("actions/bless");                  
		this.setName("Bless");
		
		this.setTime(10);
	
		Modifier tohit=new Modifier(StabConstants.TOHIT,StabConstants.SACREDMOD, +1);
		Modifier savef=new Modifier(StabConstants.FORTITUDESAVE,StabConstants.SACREDMOD, +1);
		Modifier saver=new Modifier(StabConstants.REFLEXSAVE,StabConstants.SACREDMOD, +1);
		Modifier savew=new Modifier(StabConstants.WILLSAVE,StabConstants.SACREDMOD, +1);
		
		addTrait(tohit);
		addTrait(savef);
		addTrait(saver);
		addTrait(savew);
		
		}
}
