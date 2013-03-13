package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.util.Roll;

public class FortitudeAttack extends Applicable{

	
	public static final int HIT = 0;
	public static final int MISS = 10;
	public static final int CRITICAL= 5;
	public static final int BOTCH = 11;
	
	public FortitudeAttack(BaseInfo instigator) {
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
		
		int save = aMatar.getValue(StabConstants.FORTITUDESAVE);
		int dado = Roll.d20();
		int saveroll=save+dado;
		int dc = elqueMata.getValue(StabConstants.DC);
		
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
