package com.stab.data.info.equipment.traits;

import com.stab.data.info.applicable.RolledDamage;
import com.stab.data.info.applicable.WeaponAttack;
import com.stab.data.info.equipment.WeaponTrait;
import com.stab.model.info.applicable.base.Damage;

public class FlamingWeapon extends WeaponTrait {

	@Override
	public void affect(WeaponAttack app) {
		app.addOnDamage(new RolledDamage(6, 0, Damage.FIRE_DAMAGE, null));
		String s=app.getAnimationIcon();
		app.setAnimationIcon("PARTICLE#effects/flamingStrike#"+s);
	}
	
}
