package com.stab.data.info.debuff.condition;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.Attack;
import com.stab.data.info.applicable.AttackData;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Debuff;
import com.stab.util.Roll;

public class BlindCondition extends Debuff  implements Attends<AttackData> {

	public static final String ID="BLINDEDCONDITION_DEBUFF";
	BaseInfo i = getTarget();
	int moddex = i.getAttributeValue(StabConstants.DEXTERITY);
	Modifier ac=new Modifier(StabConstants.PASSIVEDEFENSE, -2);
	Modifier acdexa = new Modifier(StabConstants.ACTIVEDEFENSE, -moddex);
	Modifier acdexp = new Modifier(StabConstants.PASSIVEDEFENSE, -moddex);
	int mov = i.getActionPoints();
	
	
	public BlindCondition() {
		
		this.setName("Blinded");
		
		addTrait(ac);
		addTrait(acdexa);
		addTrait(acdexp);
		
		i.setActionPoints(mov/2);
		
	}
	
	 @Override
	public void end() {
		 
		 removeTrait(ac);
		 removeTrait(acdexa);
		 removeTrait(acdexp); 
		 i.setActionPoints(mov);
		 super.end();
		 
	}

	@Override
	public void attend(AttackData arg0) {
		int roll = Roll.d2();
		if (roll == 1)
			arg0.setResult(Attack.MISS);
		
		
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		return false;
	}
}
