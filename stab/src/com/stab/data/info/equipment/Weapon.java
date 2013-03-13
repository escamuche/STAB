package com.stab.data.info.equipment;

import com.stab.data.info.applicable.AttackData;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.Equipment;

public abstract class Weapon extends Equipment implements Attends<AttackData>{

	@Override
	public boolean canAttend(Applicable a) {
		return a instanceof AttackData;
	}

	@Override
	public void attend(AttackData app) {
		
	}

}
