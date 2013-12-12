package com.stab.data.info.traits;

import com.stab.data.info.applicable.Attack;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.AdvancedTrait;

public class CriticalImmunity extends AdvancedTrait  implements Attends<Attack>{

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof Attack)
			return true;
		return false;
	}

	@Override
	public void attend(Attack app) {
		app.cantCrit();
	}

	
	
	
}

