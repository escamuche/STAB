package com.stab.pf.info.debuff.condition;

import com.stab.common.utils.Roll;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.Attack;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DebuffEffect;
import com.stab.pf.StabConstants;

public class BlindCondition extends DebuffEffect  implements Affects<WeaponAttack> {

	public static final String ID="BLINDEDCONDITION_DEBUFF";
	
	
	public BlindCondition() {
		
		this.setName("Blinded");
		
		Modifier ac=new Modifier(StabConstants.PASSIVEDEFENSE, -2);
		
		addTrait(ac);
		addTrait(new CannotThreatCondition());
		
	}
	
	@Override
	public void turnStarts() {
		
		Creature i = (Creature) getTarget();
		int mov = i.getMovePoints();
		i.setMovePoints(mov/2);
		super.turnStarts();
	}

	@Override
	public void affect(WeaponAttack arg0) {
		int roll = Roll.d2();
		if (roll == 1)
			arg0.setResult(Attack.MISS);	
	}

	@Override
	public boolean canAffect(Applicable arg0) {
		if(arg0 instanceof WeaponAttack)
			return true;
		else
		return false;
	}
}
