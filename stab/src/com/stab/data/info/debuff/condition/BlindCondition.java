package com.stab.data.info.debuff.condition;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.Attack;
import com.stab.data.info.applicable.AttackData;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Debuff;
import com.stab.util.Roll;

public class BlindCondition extends Debuff  implements Attends<AttackData> {

	public static final String ID="BLINDEDCONDITION_DEBUFF";
	
	
	public BlindCondition() {
		
		this.setName("Blinded");
		
		Modifier ac=new Modifier(StabConstants.PASSIVEDEFENSE, -2);
		
		addTrait(ac);
		
		
	}
	
	@Override
	public void turnStarts() {
		
		Creature i = (Creature) getTarget();
		int mov = i.getMovePoints();
		i.setMovePoints(mov/2);
		super.turnStarts();
	}

	@Override
	public void attend(AttackData arg0) {
		int roll = Roll.d2();
		if (roll == 1)
			arg0.setResult(Attack.MISS);	
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		if(arg0 instanceof AttackData)
			return true;
		else
		return false;
	}
}
