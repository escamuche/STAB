package com.stab.data.info.player.abilities;

import com.stab.common.utils.Roll;
import com.stab.data.info.applicable.WeaponAttack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.trait.Trait;

public class SneakAttack_Ability extends Trait implements Affects<WeaponAttack>{

	
	public static final String ID="SNEAK_ATTACK";
	
	
	public SneakAttack_Ability() {
	}
	
	@Override
	public boolean canAffect(Applicable a) {
		if (a instanceof WeaponAttack)
			return true;
		return false;
	}

	@Override
	public void affect(WeaponAttack app) {

		BaseInfo target= app.getTarget();
		Info attacker= app.getInstigator();
		
		
		//TODO: cambiar por un applicable, sneak attack
		
		//if (isValidSneak(attacker,target))
	/*	
		int dmg=getDamage(attacker,target);
		if (dmg>0)
			app.addOnDamage(new RolledDamage(dmg,app.getBaseDamageType()));
			/**/
	}
	
	


}
