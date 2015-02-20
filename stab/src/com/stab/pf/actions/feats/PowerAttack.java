package com.stab.pf.actions.feats;


import java.awt.Point;

import com.stab.model.action.Action;
import com.stab.model.action.StanceAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.info.buff.PowerAttack_Buff;

public class PowerAttack extends Action implements  StanceAction {
	
	public static final String ID="POWERATTACK";
	
	
	
	public PowerAttack() {
		this.setName("Power");
		this.setResource("actions/ability_backstab");
		this.setUsableByAI(false);
		setTargetMode(SELF);
		setAPCost(0);
	}
	
	@Override
	public int affect(Info instigator,Info target,Point point, ActionRequest ar) {
		BaseInfo self=(BaseInfo)target;
		
		int bab = self.getValue(StabConstants.BAB);
		PowerAttack_Buff buff= new PowerAttack_Buff(bab);
		
		if(self.hasTrait(buff.getId()) == true) {
			self.removeTrait(buff.getId());
			return OK;
		}
		else {
			
		self.addTrait(buff);

		return OK;
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


	
}