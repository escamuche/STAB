package com.stab.data.info.equipment.traits;

import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.trait.base.gear.WeaponTrait;

public class FlamingWeapon extends WeaponTrait {

	@Override
	public void affect(WeaponAttack app) {
		app.addOnDamage(new RolledDamage(6, 0, Damage.FIRE_DAMAGE, null));
		String s=app.getAnimationIcon();
		app.setAnimationIcon("PARTICLE#effects/flamingStrike#"+s);
	}
	
}
