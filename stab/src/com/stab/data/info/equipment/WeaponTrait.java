package com.stab.data.info.equipment;

import com.stab.data.info.applicable.WeaponAttack;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.trait.Trait;

public abstract class WeaponTrait extends Trait implements Affects<WeaponAttack>{

	@Override
	public boolean canAffect(Applicable a) {
		if (!(a instanceof WeaponAttack))
			return false;
		WeaponAttack ad=(WeaponAttack)a;
		if (ad.getWeapon()!=this.getParent())
			return false;
		return true;
	}

	public void attackDone(WeaponAttack attack){
		//Nada a priori. las subclases pueden comprobar cosas, pasarselo a sus traits, etc
	}

	public int getEffectValue() {
		return 0;
	}
	
}
