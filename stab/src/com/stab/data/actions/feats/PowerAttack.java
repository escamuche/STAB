package com.stab.data.actions.feats;


import com.stab.data.StabConstants;
import com.stab.data.info.buff.PowerAttack_Buff;
import com.stab.model.action.SelfAction;
import com.stab.model.action.ToggleableBuffAction;
import com.stab.model.ai.AbstractPosibleAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.request.basic.ActionRequest;

public class PowerAttack extends SelfAction implements ToggleableBuffAction {
	
	public static final String ID="POWERATTACK";
	
	
	
	public PowerAttack() {
		this.setName("Power");
		this.setResource("actions/ability_backstab");
		this.setUsableByAI(false);
	
	}
	
	@Override
	public boolean execute(BaseInfo self) {
		
		int bab = self.getValue(StabConstants.BAB);
		PowerAttack_Buff buff= new PowerAttack_Buff(bab);
		
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

	@Override
	public String getBuffId() {
		return null;
	}

	@Override
	public int shouldBeOn(AbstractPosibleAction arg0) {
		return 0;
	}
	
}