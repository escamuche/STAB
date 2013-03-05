package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.util.Roll;

public class ReflexAttack extends Applicable{

	
	public static final int HIT = 0;
	public static final int MISS = 10;
	public static final int CRITICAL= 5;
	public static final int BOTCH = 11;

	//En un futuro añadir o reutilizar los que hay para "le has dado a una imagen" o "fallo por concealment", etc
	//Añadir tambien si ha sido CA, dodge, cover, parry o block lo que ha parado el ataque (con vistas a animacion)
	
	public ReflexAttack(BaseInfo instigator) {
		super(instigator);
	}


	@Override
	public void apply() {
		BaseInfo aMatar = getTarget();
		BaseInfo elqueMata = (BaseInfo) getInstigator();
		
		int save = aMatar.getValue(StabConstants.REFLEXSAVE);
		int dado = Roll.d20();
		int saveroll=save+dado;
		int dc=elqueMata.getValue(StabConstants.DC);
		
		if (saveroll < dc) {
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

