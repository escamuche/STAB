package com.stab.data.actions.player.abilities;

import java.awt.Point;

import com.stab.data.info.alignment.Evil;
import com.stab.data.info.buff.SmiteEvil_Buff;
import com.stab.data.info.debuff.SmiteEvil_Debuff;
import com.stab.model.action.Action;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class SmiteEvil extends Action {
	
	public static final String ID="SMITEEVIL";
	public static final String RESOURCE_ID="SMITEEVIL";
	
	public SmiteEvil() {
     
     setResource("actions/smite");
     setName("Smite Evil");
     this.setEffectType(DEBUFF);
     this.setRequiredResource(SmiteEvil.RESOURCE_ID, 1);
     setAPCost(0);
	}



	@Override
	public int affect(Info instigator,Info receive,Point point, ActionRequest ar) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		
		caster.spendResource(SmiteEvil.RESOURCE_ID, 1);
		
		if(target.hasTrait(Evil.ID)){
			SmiteEvil_Buff buff = new SmiteEvil_Buff();
			buff.setSmiteTarget(target);
			caster.addTrait(buff);
	
			SmiteEvil_Debuff debuff = new SmiteEvil_Debuff();
			debuff.setPaladin(caster);
			target.addTrait(debuff);
			
			
			return OK;
		}
		
		return FAIL;
		
	}

	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return false;
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