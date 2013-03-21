package com.stab.data.actions.player.abilities;

import com.stab.data.StabConstants;
import com.stab.data.info.buff.Rage_Buff;
import com.stab.data.info.debuff.Rage_Debuff;
import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;

public class Rage extends SelfAction{
	
	public static final String ID="RAGE";

	Rage_Buff buff = new Rage_Buff(null);
	Rage_Debuff debuff = new Rage_Debuff(null);
	
	public Rage() {
     
     setResource("actions/rage");
     setName("Rage");
     this.setEffectType(BUFF);
	}



	@Override
	public boolean execute(BaseInfo self) {
		
		if(self.getAttributeValue(StabConstants.RAGEROUNDSSPENT) <= self.getAttributeValue(StabConstants.RAGEROUNDS)) /*&& self.getTrait(FatiguedCondition.ID) = false)*/ {	
			
				self.addTrait(buff);
				return true;
		
				}
		
			else {
				self.removeTrait(buff);
				self.addTrait(debuff);
				return false;
				}
}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 25;
	}
	

}
