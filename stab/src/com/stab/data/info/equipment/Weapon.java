package com.stab.data.info.equipment;

import com.stab.data.info.applicable.AttackData;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;

public abstract class Weapon extends Item implements Attends<AttackData>{

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof AttackData)
			return ((AttackData)a).getWeapon()==this;
		return false;
	}

	@Override
	public void attend(AttackData app) {
		app.setFilled(true);
	}

	
	
}
