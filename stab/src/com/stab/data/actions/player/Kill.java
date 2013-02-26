package com.stab.data.actions.player;

import com.stab.data.StabConstants;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.events.common.ConsoleMessage;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.Effect;
import com.stab.model.info.trait.Modifier;
import com.stab.util.Roll;

public class Kill extends TargetAction{
	
	public static final String ID="Kill";
	public boolean critico=false;
	public boolean pifia=false;

	@Override
	public boolean execute(Info yo, Info target) {
		BaseInfo aMatar = (BaseInfo)target;
		BaseInfo elqueMata = (BaseInfo)yo;
		
		int ac = aMatar.getValue(StabConstants.ARMOR);
		int dado = Roll.d20();
		int dañobase=elqueMata.getValue(StabConstants.DAMAGE);
		
		Modifier critical= Modifier.createMod(StabConstants.DAMAGE, +dañobase);
		
		if (dado == 20) {  
			Effect buffdaño = Effect.createRound("buffcritico", critical);		
		    elqueMata.addTrait(buffdaño);
		    critico=true;
		    return true;
			}
		
		if (dado == 1) {
			pifia=true;
			return false;
		    }
		
		int dar = elqueMata.getValue(StabConstants.TOHIT) + dado;
		elqueMata.getScene().sendMessage(ConsoleMessage.SUCCESS, "Impactas a armadura " + dar);
	
		if (ac <= dar) { //si das a ca
			
			if (pifia == true) { //pero es pifia
				elqueMata.getScene().sendMessage(ConsoleMessage.ERROR, "Fallas el golpe");
				return false;				
							}
		           //das y no es pifia
						Damage d= new Damage(elqueMata.getValue(StabConstants.DAMAGE), Damage.SLASHING_DAMAGE,yo);
						aMatar.apply(d);
						elqueMata.getScene().sendMessage(ConsoleMessage.WARNING, d.getAmount()+" de daño");
						return true;	
		}
			else { // si no das a ca
				if (critico == true) { //pero es critico
					Damage d= new Damage(elqueMata.getValue(StabConstants.DAMAGE), Damage.SLASHING_DAMAGE,yo);
					aMatar.apply(d);
					elqueMata.getScene().sendMessage(ConsoleMessage.WARNING, d.getAmount()+" de daño");
					return true;	
					}
				 //no das y no es critico
				elqueMata.getScene().sendMessage(ConsoleMessage.ERROR, "Fallas el golpe");
				return false;	
		    }
			
		}
	
	public Kill() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_warrior_defensivestance");
	}

	public static void main(String[] args) {

	}
	

}
