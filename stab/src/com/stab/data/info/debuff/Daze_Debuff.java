package com.stab.data.info.debuff;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Buff;

public class Daze_Debuff extends Buff {

	public static final String ID="DAZE_DEBUFF";
	
	public Daze_Debuff() {
	
		
		this.setAnimIcon("actions/ability_druid_naturalperfection");				
		this.setSound("HolyCast");
		this.setResource("actions/ability_druid_naturalperfection");                  
		this.setName("Bless");
		
		this.setTime(1);
		//falta crear un estado stun
		}
	
		@Override
		public void turnStarts() {
			this.getTarget().setTurnDone(true);
			super.turnStarts();
		
		}
}
