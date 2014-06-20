package com.stab.data.info.traits;

import com.stab.data.info.applicable.PathfinderAttack;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.AdvancedTrait;

public class CriticalImmunity extends AdvancedTrait  implements Attends<PathfinderAttack>{

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof PathfinderAttack)
			return true;
		return false;
	}

	@Override
	public void attend(PathfinderAttack app) {
		app.cantCrit();
	}

	
	
	
}

