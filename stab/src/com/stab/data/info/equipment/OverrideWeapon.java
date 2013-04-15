package com.stab.data.info.equipment;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.base.Creature;

public class OverrideWeapon extends Weapon {
	
	
	Weapon old;
	
	public OverrideWeapon(Weapon old) {
		this.old=old;
	}

	
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		((Creature)baseInfo).equip(old);
	}
	
}
