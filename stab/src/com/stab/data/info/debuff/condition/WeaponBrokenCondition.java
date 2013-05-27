package com.stab.data.info.debuff.condition;

import com.stab.data.info.applicable.WeaponAttack;
import com.stab.data.info.equipment.BasicWeapon;
import com.stab.data.info.equipment.Weapon;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.trait.base.Debuff;

public class WeaponBrokenCondition extends Debuff implements Affects<WeaponAttack>{
	
	public static final String ID="BROKENCONDITION_DEBUFF";
	Weapon weapon = null;
	
	WeaponBrokenCondition(Weapon i) {
		
		this.setAnimIcon("actions/brokencondition");				
		this.setSound("HolyCast");
		this.setResource("actions/brokencondition");                  
		
		this.setName("Broken");
		this.setPermanent();
		weapon = i;
	}

	@Override
	public void affect(WeaponAttack arg0) {
		arg0.addModifier(-2);
		arg0.setBaseDamage(arg0.getBaseDamage()-2);
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
