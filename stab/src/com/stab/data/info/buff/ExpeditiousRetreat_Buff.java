package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class ExpeditiousRetreat_Buff extends Buff {

	public static final String ID="TRUESTRIKE_BUFF";
	
	public ExpeditiousRetreat_Buff(BaseInfo caster) {
	
		
		this.setAnimIcon("actions/ability_shaman_watershield");				
		this.setSound("HolyCast");
		this.setResource("actions/ability_shaman_watershield");                  
		this.setName("Expeditious Retreat");
		
		this.setTime(10);
	
		int mov=caster.getActionPoints();
		/*Modifier speed=Modifier.createMod(mov,mov*2);
		addTrait(speed);*/
		}
}
