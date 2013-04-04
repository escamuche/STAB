package com.stab.data.info.equipment;

import com.stab.data.info.applicable.WeaponAttack;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;

public abstract class Weapon extends Item implements Affects<WeaponAttack>{

	@Override
	public boolean canAffect(Applicable a) {
		if (a instanceof WeaponAttack)
			return ((WeaponAttack)a).getWeapon()==this;
		return false;
	}

	@Override
	public void affect(WeaponAttack app) {
		
	}

	public void attackDone(WeaponAttack attack){
		//Nada a priori. las subclases pueden comprobar cosas, pasarselo a sus traits, etc
	}
	
}
