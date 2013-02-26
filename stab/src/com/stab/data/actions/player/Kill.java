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
		int dado = Roll.d20()+1;
		int dañobase=elqueMata.getValue(StabConstants.DAMAGE);
		System.out.println(dado + " en el dado!");
		
		
		if (dado == 20) {
			System.out.println("Posibilidad de Critico!");
			int confir=Roll.d20();
			int caconfir=elqueMata.getValue(StabConstants.TOHIT) + confir;
			if(ac <= caconfir) {
			dañobase=dañobase*2;
		    critico=true;
		    System.out.println("Critico!!!");
			   }
			else{
				System.out.println("Fallaste la confirmacion!");
			}
			}
		
		if (dado == 1) {
			System.out.println("Posibilidad de Pifia!");
		    int confir=Roll.d20();
		    int caconfir=elqueMata.getValue(StabConstants.TOHIT) + confir;
		    if(ac <= caconfir) {
	        System.out.println("Casi!");
		   }
		else{
			System.out.println("Pifia!!!");
			pifia=true;
		    }
		
		int dar = elqueMata.getValue(StabConstants.TOHIT) + dado;
		System.out.println("Impactas a armadura " + dar);
	
		if (ac <= dar) { //si das a ca
			
			if (pifia == true) { //pero es pifia
				System.out.println("Fallas el golpe");
				return false;				
							}
		           //das y no es pifia
						Damage d= new Damage(elqueMata.getValue(StabConstants.DAMAGE), Damage.SLASHING_DAMAGE,yo);
						aMatar.apply(d);
						System.out.println(d.getAmount()+" de daño");
						return true;	
		}
			else { // si no das a ca
				if (critico == true) { //pero es critico
					Damage d= new Damage(elqueMata.getValue(StabConstants.DAMAGE), Damage.SLASHING_DAMAGE,yo);
					aMatar.apply(d);
					System.out.println(d.getAmount()+" de daño");
					return true;	
					}
				 //no das y no es critico
				System.out.println("Fallas el golpe");
				return false;	
		    }
		}
		return critico;
		}
	
	public Kill() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_steelmelee");
	}

	public static void main(String[] args) {

	}
	

}
