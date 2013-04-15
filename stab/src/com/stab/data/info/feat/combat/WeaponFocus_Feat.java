package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.WeaponAttack;
import com.stab.data.info.equipment.BasicWeapon;
import com.stab.data.info.equipment.Weapon;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;

public class WeaponFocus_Feat extends CombatFeat implements Affects<WeaponAttack> {
	
	public static final String ID="WEAPONFOCUS_FEAT";

	String weapon;
	
	public WeaponFocus_Feat(String arma) {
		
		this.weapon = arma;
		
		this.addRequiredAttribute(StabConstants.BAB, 1);
			}

	@Override
	public void affect(WeaponAttack arg0) {
		
		arg0.addModifier(+1);
		
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
