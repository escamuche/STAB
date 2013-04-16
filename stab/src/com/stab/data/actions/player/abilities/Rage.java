package com.stab.data.actions.player.abilities;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.info.buff.Rage_Buff;
import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.action.Action;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Rage extends Action implements SelfAction{
	
	public static final String ID="RAGE";
	
	public Rage() {
     
     setResource("actions/rage");
     setName("Rage");
     this.setEffectType(BUFF);
	}



	@Override
	public boolean affect(Info instigator,Info receive,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		
		if(target.hasTrait(Rage_Buff.ID)){ //si tiene rabia activa la quita y vuelve
			target.removeTrait(Rage_Buff.ID);
			return true;
		}
		else { //si no la tiene activa seguimos
			
			int i = caster.getValue(StabConstants.RAGEROUNDS);
			int j = caster.getValue(StabConstants.RAGEROUNDSSPENT);
				if(i-j <=0)   // si no ha gastado todos los round de rabia sigue, si no vuelve
					return false;
					if(target.hasTrait(FatiguedCondition.ID)) // por ultimo comprobar que no esta fatigued, si pasa todo sigue
						return false;
			Rage_Buff buff = new Rage_Buff(); 
			target.addTrait(buff); //aplicando el buff
			buff.setTime(i-j); //el max de duracion es este, los rounds que tienes menos los que gastaste
			return true;
		}
}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 25; // valor alto para que los bichos lo usen prioritariamente
	}
	

}
