package com.stab.data.actions.player.feats;

import com.stab.data.StabConstants;
import com.stab.data.info.buff.Expertise_Buff;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.request.basic.ActionRequest;

public class Expertise extends SelfAction {
	
	public static final String ID="EXPERTISE";

	Expertise_Buff buff = new Expertise_Buff();
	
	public Expertise() {
		
		this.setName("Expertise");
		this.setResource("actions/ability_warrior_safeguard");
		this.setUsableByAI(false);
	
	}
	
	@Override
	public boolean execute(BaseInfo self) {
	
		if(self.hasTrait(buff.getId()) == true) {
			self.removeTrait(buff.getId());
			return false;
		}
		else {
			
		self.addTrait(buff);
		
		System.out.println("Bono de armadura: " + self.getValue(StabConstants.ARMOR));
		System.out.println("Bono a dar: " + self.getValue(StabConstants.TOHIT));

		return true;
		}
	}
	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return false;
	}
		
}
