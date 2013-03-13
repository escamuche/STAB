package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.util.Roll;

public class RangedAttack extends Applicable{

	
	public static final int HIT = 0;
	public static final int MISS = 10;
	public static final int CRITICAL= 5;
	public static final int BOTCH = 11;

	//En un futuro añadir o reutilizar los que hay para "le has dado a una imagen" o "fallo por concealment", etc
	//Añadir tambien si ha sido CA, dodge, cover, parry o block lo que ha parado el ataque (con vistas a animacion)
	
	public RangedAttack(BaseInfo instigator) {
		super(instigator);
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apply() {
		BaseInfo aMatar = getTarget();
		BaseInfo elqueMata = (BaseInfo) getInstigator();
		
		int ac = aMatar.getValue(StabConstants.ARMOR);
		int dado = Roll.d20();


		int hit=elqueMata.getValue(StabConstants.TOHITRANGED);
		System.out.println(dado + " en el dado!");
		
		
		if (dado == 20) {
			System.out.println("Posibilidad de Critico!");
			int confirc=Roll.d20();
			int caconfirc=hit + confirc;
			if(ac <= caconfirc) {
				System.out.println("Critico!!!");
				setResult(CRITICAL);
			   	}
			else{
				System.out.println("Fallaste la confirmacion!");
				setResult(HIT);
				}
			}
		
		
		if (dado == 1) {
			System.out.println("Posibilidad de Pifia!");
		    int confirp=Roll.d20();
		    int caconfirp=hit + confirp;
		    if(ac <= caconfirp) {
		    	System.out.println("Casi!");
		    	setResult(MISS);
		    	}
		    	else{
		    		System.out.println("Pifia!!!");
		    		setResult(BOTCH);
		    		}
			}
		
		
		int dar = elqueMata.getValue(StabConstants.TOHITRANGED) + dado;
		System.out.println("Impactas a armadura " + dar);
	
		if (ac <= dar) { //si das a ca
			setResult(HIT);
		}
		else{
			setResult(MISS);
		}
					
	}
	
	public boolean hits(){
		return getResult()==HIT || getResult()==CRITICAL;
	}
	
	public boolean misses(){
		return !hits();
	}
	
	public boolean isCritical(){
		return getResult()==CRITICAL;
	}
	public boolean isBotch(){
		return getResult()==BOTCH;
	}
	
	
}
