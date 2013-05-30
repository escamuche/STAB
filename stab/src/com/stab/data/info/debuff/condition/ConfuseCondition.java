package com.stab.data.info.debuff.condition;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.info.applicable.RolledDamage;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Debuff;

public class ConfuseCondition extends Debuff {

	public static final String ID="CONFUSECONDITION_DEBUFF";
	BaseInfo target=null;
	
	public ConfuseCondition() {
		
		this.setName("Confuse");
		target = getTarget();
		
		
	}
	
	@Override
	public void turnStarts() {
		
		int t = Roll.d4();
		
		if(t==2)
			target.isTurnDone();
		
		if(t==3){
			RolledDamage damage = new RolledDamage(1,8,target.getAttributeValue(StabConstants.STRENGHT),target);
			target.apply(damage);
			target.isTurnDone();
		}
		if(t==4){
			//aqui atacar a lo mas cercano
		}
		
		
		super.turnStarts();
	}

}