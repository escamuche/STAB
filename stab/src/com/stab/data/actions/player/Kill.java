package com.stab.data.actions.player;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.Attack;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class Kill extends TargetAction{
	
	public static final String ID="Kill";

	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacante = (BaseInfo)yo;
		BaseInfo Atacado = (BaseInfo)target;
		int dañobase=Atacante.getValue(StabConstants.DAMAGE);
		
		Attack ataque = new Attack(Atacante);
		Atacado.apply(ataque);
		
		if (ataque.hits()) {
			
			Damage d= new Damage(dañobase, Damage.SLASHING_DAMAGE,yo);
			Atacado.apply(d);
			System.out.println(d.getFinalAmount()+" de daño");
			return true;	
		}
		
		if (ataque.isCritical()) {
			
			dañobase=dañobase*2;
			Damage d= new Damage(dañobase, Damage.SLASHING_DAMAGE,yo);
			Atacado.apply(d);
			System.out.println(d.getFinalAmount()+" de daño");
			return true;	
			
		}
		
		if (ataque.isBotch()) {
			
			System.out.println("Pero mira que eres torpe!");
		    return false;
		}
		
		return true;
		
	}
		/*else {
			
			System.out.println("Fallaste!");
			return false;
		}
	}
		/*BaseInfo aMatar = (BaseInfo)target;
		BaseInfo elqueMata = (BaseInfo)yo;
		
		int ac = aMatar.getValue(StabConstants.ARMOR);
		int dado = Roll.d20();
		int dañobase=elqueMata.getValue(StabConstants.DAMAGE);
		int hit=elqueMata.getValue(StabConstants.TOHIT);
		boolean critico=false;
		boolean pifia=false;
		System.out.println(dado + " en el dado!");
		
		
		if (dado == 20) {
			System.out.println("Posibilidad de Critico!");
			int confirc=Roll.d20();
			int caconfirc=hit + confirc;
			if(ac <= caconfirc) {
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
		    int confirp=Roll.d20();
		    int caconfirp=hit + confirp;
		    if(ac <= caconfirp) {
		    	System.out.println("Casi!");
		    	}
		    	else{
		    		System.out.println("Pifia!!!");
		    		pifia=true;
		    		}
			}
		
		
		int dar = elqueMata.getValue(StabConstants.TOHIT) + dado;
		System.out.println("Impactas a armadura " + dar);
	
		if (ac <= dar) { //si das a ca
			
			if (pifia == true) { //pero es pifia
				System.out.println("Fallas el golpe");
				return false;				
							}
		           //das y no es pifia
						Damage d= new Damage(dañobase, Damage.SLASHING_DAMAGE,yo);
						aMatar.apply(d);
						System.out.println(d.getAmount()+" de daño");
						return true;	
		}
			else { // si no das a ca
				if (critico == true) { //pero es critico
					Damage d= new Damage(dañobase, Damage.SLASHING_DAMAGE,yo);
					aMatar.apply(d);
					System.out.println(d.getAmount()+" de daño");
					return true;	
					}
				 //no das y no es critico
				System.out.println("Fallas el golpe");
				return false;	
		    }
		} */
	
	public Kill() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_steelmelee");
     setName("Attack");
     this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return i.getAttributeValue(StabConstants.DAMAGE);
	}
	

}
