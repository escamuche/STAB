package com.stab.data.actions.feats;

import com.stab.data.StabConstants;
import com.stab.data.info.buff.Expertise_Buff;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.request.basic.ActionRequest;

public class Expertise extends SelfAction {
	
	public static final String ID="EXPERTISE";

	
	
	public Expertise() {
		
		this.setName("Expertise");
		this.setResource("actions/ability_warrior_safeguard");
		//this.setUsableByAI(false);
	
	}
	
	@Override
	public boolean execute(BaseInfo self) {
	
		int bab = self.getValue(StabConstants.BAB);
		Expertise_Buff buff = new Expertise_Buff(bab);
		if(self.hasTrait(buff.getId()) == true) {
			self.removeTrait(buff.getId());
			return false;
		}
		else {
			
		self.addTrait(buff);

		return true;
		}
	}
	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return false;
	}
		
}
