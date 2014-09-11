package com.stab.data.info.equipment;

import com.stab.model.info.trait.base.gear.Weapon;

public class Arrow extends BasicAmmo {

	
	public Arrow(String name, int dices, int dice, int baseDamageType,
			int critRange, int critMultiplier, String animationIcon) {
		super(name, dices, dice, baseDamageType, critRange, critMultiplier,
				animationIcon);
	}

	@Override
	public boolean isValidForWeapon(Weapon w) {
		if (super.isValidForWeapon(w))
			return w instanceof Bow;
		return false;
	}
	
}
