package com.stab.data.actions.feats;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.info.buff.Expertise_Buff;
import com.stab.model.action.Action;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class Expertise extends Action implements SelfAction {
	
	public static final String ID="EXPERTISE";

	
	
	public Expertise() {
		
		this.setName("Expertise");
		this.setResource("actions/ability_warrior_safeguard");
		//this.setUsableByAI(false);
	
	}
	
	@Override
	public int affect(Info instigator,Info target,Point point) {
		BaseInfo self=(BaseInfo)target;
		int bab = self.getValue(StabConstants.BAB);
		Expertise_Buff buff = new Expertise_Buff(bab);
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
		
}
