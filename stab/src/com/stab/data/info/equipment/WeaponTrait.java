package com.stab.data.info.equipment;

import com.stab.data.info.applicable.Attack;
import com.stab.data.info.applicable.AttackData;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.Trait;

public abstract class WeaponTrait extends Trait implements Attends<AttackData>{

	@Override
	public boolean canAttend(Applicable a) {
		if (!(a instanceof AttackData))
			return false;
		AttackData ad=(AttackData)a;
		if (ad.getWeapon()!=this.getParent())
			return false;
		return true;
	}

	public void attackDone(Attack attack){
		//Nada a priori. las subclases pueden comprobar cosas, pasarselo a sus traits, etc
	}
	
}
