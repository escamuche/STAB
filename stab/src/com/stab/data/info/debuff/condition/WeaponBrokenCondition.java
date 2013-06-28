package com.stab.data.info.debuff.condition;

import com.stab.data.info.applicable.WeaponAttack;
import com.stab.data.info.equipment.BasicWeapon;
import com.stab.data.info.equipment.Weapon;
import com.stab.data.info.equipment.WeaponTrait;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;

public class WeaponBrokenCondition extends WeaponTrait implements Affects<WeaponAttack>{
	
	public static final String ID="WEAPONBROKENCONDITION";
	Weapon weapon = null;
	
	WeaponBrokenCondition(Weapon i) {          
		weapon = i;
	}

	@Override
	public void affect(WeaponAttack arg0) {
		arg0.addModifier(-2);
		arg0.modifyBaseDamage(-2);
		arg0.setCritMultiplier(2);
		arg0.setCritRange(20);
	}

	@Override
	public boolean canAffect(Applicable a) {
		if (a instanceof WeaponAttack) {
			WeaponAttack ataque = (WeaponAttack) a;
			if(ataque.getWeapon() instanceof BasicWeapon){
				Weapon b = (Weapon) ataque.getWeapon();
				return (b.getBaseItem().equals(weapon));
				}
			}
		return false;
	}
	
	
}
