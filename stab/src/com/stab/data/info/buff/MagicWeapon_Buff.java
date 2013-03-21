package com.stab.data.info.buff;

import com.stab.data.info.applicable.AttackData;
import com.stab.data.info.equipment.BasicWeapon;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.Buff;

public class MagicWeapon_Buff extends Buff implements Attends<AttackData> {

	public static final String ID="MAGICWEAPON_BUFF";
	String weapon;
	
	public MagicWeapon_Buff(BaseInfo atacante, String arma) {
	
		
		this.setAnimIcon("actions/magicweapon");				
		this.setSound("HolyCast");
		this.setResource("actions/magicweapon");                  
		this.setName("Magic Weapon");
		
		this.weapon=arma;
		
		this.setTime(10);
		
		}

	@Override
	public void attend(AttackData ad) {
		
		ad.getAttack().addModifier(+1);
		
	}

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof AttackData) {
			AttackData ataque = (AttackData) a;
			if(ataque.getWeapon() instanceof BasicWeapon){
				BasicWeapon b = (BasicWeapon) ataque.getWeapon();
				return (b.getBaseWeapon().equals(weapon));
				}
			}
		return false;
	}
}