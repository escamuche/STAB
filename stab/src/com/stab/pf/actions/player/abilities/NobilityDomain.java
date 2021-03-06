package com.stab.pf.actions.player.abilities;

import java.awt.Point;

import com.stab.model.action.Action;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.info.buff.NobilityDomain_Buff;

public class NobilityDomain extends Action  {
	
	public static final String ID="NOBILITYDOMAIN";
	public static final String RESOURCE_ID="NOBILITYDOMAIN";
	
	public NobilityDomain() {
	setTargetMode(Action.TARGET);
     setResource("actions/nobility");
     setName("Nobility Domain");
     this.setEffectType(BUFF);
     this.setRequiredResource(NobilityDomain.RESOURCE_ID, 1);
     this.setRange(6);
     this.setDescription("");
	}



	@Override
	public int affect(Info instigator,Info receive,Point point, ActionRequest ar) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		
		
			NobilityDomain_Buff buff = new NobilityDomain_Buff();
			int n = caster.getValue(StabConstants.CLERICCASTER)/2;
			if(n==0)
				n=1;
			buff.setTime(n);
			target.addTrait(buff);
			
			caster.spendResource(NobilityDomain.RESOURCE_ID, 1);
			return OK;
	}


	
	@Override
	protected boolean payResources(BaseInfo i) {
		return true;
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 25; // valor alto para que los bichos lo usen prioritariamente
	}
	

}
