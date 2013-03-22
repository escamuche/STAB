package com.stab.data.actions.player.abilities;

import com.stab.data.StabConstants;
import com.stab.data.info.buff.Rage_Buff;
import com.stab.data.info.debuff.Rage_Debuff;
import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;

public class Rage extends SelfAction{
	
	public static final String ID="RAGE";

	Rage_Buff buff = new Rage_Buff();		// se crea el buff para clonar el objeto o seria compartido por todos los objetos que usen el buff... igual que todos los buff, algo falla aqui?
	Rage_Debuff debuff = new Rage_Debuff(); //y este no se usa?
	
	public Rage() {
     
     setResource("actions/rage");
     setName("Rage");
     this.setEffectType(BUFF);
	}



	@Override
	public boolean execute(BaseInfo self) {
		
		if(self.hasTrait(Rage_Buff.ID)){ //si tiene rabia activa la quita y vuelve
			self.removeTrait(Rage_Buff.ID);
			return true;
		}
		else { //si no la tiene activa seguimos
			
			int i = self.getValue(StabConstants.RAGEROUNDS);
			int j = self.getValue(StabConstants.RAGEROUNDSSPENT);
				if(i-j <=0)   // si no ha gastado todos los round de rabia sigue, si no vuelve
					return false;
					if(self.hasTrait(FatiguedCondition.ID)) // por ultimo comprobar que no esta fatigued, si pasa todo sigue
						return false;
			//Rage_Buff buff = new Rage_Buff(); esta arriba, esto sobraria, no?
			self.addTrait(buff); //aplicando el buff
			buff.setTime(i-j); //el max de duracion es este, los rounds que tienes menos los que gastaste
			return true;
		}
}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 25; // valor alto para que los bichos lo usen prioritariamente
	}
	

}
