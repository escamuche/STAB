package com.stab.data.actions.player.abilities;

import java.awt.Point;

import com.stab.data.info.buff.SmiteEvil_Buff;
import com.stab.data.info.debuff.SmiteEvil_Debuff;
import com.stab.model.action.Action;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class SmiteEvil extends Action implements SelfAction{
	
	public static final String ID="SMITEEVIL";
	public static final String RESOURCE_ID="SMITEEVIL";
	
	public SmiteEvil() {
     
     setResource("actions/smite");
     setName("Smite Evil");
     this.setEffectType(BUFF);
     this.setRequiredResource(SmiteEvil.RESOURCE_ID, 1);
	}



	@Override
	public boolean affect(Info instigator,Info receive,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		
		
			SmiteEvil_Buff buff = new SmiteEvil_Buff();
			buff.setSmiteTarget(target);
			caster.addTrait(buff);
	
			SmiteEvil_Debuff debuff = new SmiteEvil_Debuff();
			debuff.setPaladin(caster);
			target.addTrait(debuff);
			
			target.spendResource(SmiteEvil.RESOURCE_ID, 1);
			return true;
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
	public int getEffectValue(BaseInfo i) {
		return 25; // valor alto para que los bichos lo usen prioritariamente
	}
	

}