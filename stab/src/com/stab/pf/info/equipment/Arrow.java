package com.stab.pf.info.equipment;

import com.stab.model.info.trait.base.gear.Weapon;

public class Arrow extends BasicAmmo {

	
	public Arrow(String name, Integer dices, Integer dice, Integer baseDamageType,
			Integer critRange, Integer critMultiplier, String animationIcon) {
		super(name, dices, dice, baseDamageType, critRange, critMultiplier,
				animationIcon);
		this.setMaxAmount(40);
		this.setAmount(getMaxAmount());
		setWorldResource("../effects/droparrows");
		this.setResource("items/ARROW01");
	}

	@Override
	public boolean isValidForWeapon(Weapon w) {
		if (super.isValidForWeapon(w))
			return w instanceof Bow;
		return false;
	}
	
}
