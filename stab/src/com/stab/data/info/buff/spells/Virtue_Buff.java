package com.stab.data.info.buff.spells;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.Heal;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Virtue_Buff extends Buff {

	public static final String ID="VIRTUE_BUFF";
	
	public Virtue_Buff() {
	
		
		this.setAnimIcon("actions/bless");				
		this.setSound("HolyCast");
		this.setResource("actions/bless");                  
		this.setName("Virtue");
	
		BaseInfo target=getTarget();
		if(target.hasTrait(Virtue_Buff.ID) == true) {
			
			Heal h = new Heal(1,target);
			target.apply(h);
			
		}
		
		else {
			Modifier virtue = new Modifier(StabConstants.MAXHP,"Virtue", +1);
			Heal h = new Heal(1,target);
			target.apply(h);
			target.addTrait(virtue);
			}
		}
	
}
