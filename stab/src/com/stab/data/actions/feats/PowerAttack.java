package com.stab.data.actions.feats;


import com.stab.data.StabConstants;
import com.stab.data.info.buff.PowerAttack_Buff;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.request.basic.ActionRequest;

public class PowerAttack extends SelfAction {
	
	public static final String ID="POWERATTACK";
	
	PowerAttack_Buff buff= new PowerAttack_Buff();
	
	public PowerAttack() {
		this.setName("Power");
		this.setResource("actions/ability_backstab");
		//this.setUsableByAI(false);
	
	}
	
	@Override
	public boolean execute(BaseInfo self) {
		
		
		
		if(self.hasTrait(buff.getId()) == true) {
			self.removeTrait(buff.getId());
			return false;
		}
		else {
			
		self.addTrait(buff);
		
		System.out.println("Bono de daño: " + self.getValue(StabConstants.DAMAGE));
		System.out.println("Bono a dar: " + self.getValue(StabConstants.TOHIT));

		return true;
		}
	}
	
	
	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return false;
	}
	
}