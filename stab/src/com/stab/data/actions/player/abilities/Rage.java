package com.stab.data.actions.player.abilities;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.info.buff.Rage_Buff;
import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.action.Action;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class Rage extends Action implements SelfAction{
	
	public static final String ID="RAGE";
	public static final String RESOURCE_ID="RAGE";
	
	public Rage() {
     
     setResource("actions/rage");
     setName("Rage");
     this.setEffectType(BUFF);
     this.setRequiredResource(Rage.RESOURCE_ID, 1);
	}



	@Override
	public int affect(Info instigator,Info receive,Point point, ActionRequest ar) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		//int i = caster.getValue(StabConstants.RAGEROUNDS);
		int j = caster.getValue(StabConstants.RAGEROUNDSSPENT);
		
		if(target.hasTrait(Rage_Buff.ID)){ //si tiene rabia activa la quita y vuelve
			if(j>0){						//si no ha gastado ningun turno de rabia no la desactiva
			target.removeTrait(Rage_Buff.ID);
			return OK;
			}
		}
		else { //si no la tiene activa seguimos
			
			
				//if(i-j <=0)   // si no ha gastado todos los round de rabia sigue, si no vuelve
					//return false;
					if(target.hasTrait(FatiguedCondition.ID)) // por ultimo comprobar que no esta fatigued, si pasa todo sigue
						return FAIL;
			Rage_Buff buff = new Rage_Buff(); 
			target.addTrait(buff); //aplicando el buff
			target.setAttribute(StabConstants.RAGEROUNDSSPENT, 0);
			buff.setTime(target.getResourceCount(Rage.RESOURCE_ID)); //el max de duracion es este, los rounds que tienes menos los que gastaste
			target.spendResource(Rage.RESOURCE_ID, 1);
			return OK;
		}
		return OK;
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
