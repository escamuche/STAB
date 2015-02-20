package com.stab.pf.actions.feats;

import java.awt.Point;

import com.stab.model.action.Action;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.info.buff.Expertise_Buff;

public class Expertise extends Action   {
	
	public static final String ID="EXPERTISE";

	
	
	public Expertise() {
		setTargetMode(SELF);
		this.setName("Expertise");
		this.setResource("actions/ability_warrior_safeguard");
		//this.setUsableByAI(false);
		setAPCost(0);
	
	}
	
	@Override
	public int affect(Info instigator,Info target,Point point, ActionRequest ar) {
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
	
		
}
