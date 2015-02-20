package com.stab.pf.info.debuff.condition;

import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.trait.base.gear.Weapon;
import com.stab.model.info.trait.base.gear.WeaponTrait;
import com.stab.pf.info.equipment.BasicWeapon;

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
