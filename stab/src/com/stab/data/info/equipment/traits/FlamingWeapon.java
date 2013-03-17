package com.stab.data.info.equipment.traits;

import com.stab.data.info.applicable.AttackData;
import com.stab.data.info.applicable.RolledDamage;
import com.stab.data.info.equipment.WeaponTrait;
import com.stab.model.info.applicable.base.Damage;

public class FlamingWeapon extends WeaponTrait {

	@Override
	public void attend(AttackData app) {
		app.addOnDamage(new RolledDamage(6, 0, Damage.FIRE_DAMAGE, null));
	}
	
}
