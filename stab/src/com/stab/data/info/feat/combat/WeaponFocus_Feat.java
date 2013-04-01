package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.AttackData;
import com.stab.data.info.equipment.BasicWeapon;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;

public class WeaponFocus_Feat extends CombatFeat implements Attends<AttackData> {
	
	public static final String ID="WEAPONFOCUS_FEAT";

	String weapon;
	
	public WeaponFocus_Feat(String arma) {
		
		this.weapon = arma;
		
		this.addRequiredAttribute(StabConstants.BAB, 1);
			}

	@Override
	public void attend(AttackData arg0) {
		
		arg0.getAttack().addModifier(+1);
		
	}

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof AttackData) {
			AttackData ataque = (AttackData) a;
			if(ataque.getWeapon() instanceof BasicWeapon){
				BasicWeapon b = (BasicWeapon) ataque.getWeapon();
				return (b.getBaseItem().equals(weapon));
				}
			}
		return false;
	}
}
