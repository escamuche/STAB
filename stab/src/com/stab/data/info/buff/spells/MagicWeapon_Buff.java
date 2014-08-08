package com.stab.data.info.buff.spells;

import com.stab.data.StabConstants;
import com.stab.data.info.equipment.BasicWeapon;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;

public class MagicWeapon_Buff extends BuffEffect implements Affects<WeaponAttack> {

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
	public void affect(WeaponAttack ad) {
		if (ad.isRanged())
			ad.addModifier(new Modifier(StabConstants.TOHITRANGED,StabConstants.ENHANCEMENTMOD,+1));
		else
			ad.addModifier(new Modifier(StabConstants.TOHIT,StabConstants.ENHANCEMENTMOD,+1));
		
	}

	@Override
	public boolean canAffect(Applicable a) {
		if (a instanceof WeaponAttack) {
			WeaponAttack ataque = (WeaponAttack) a;
			if(ataque.getWeapon() instanceof BasicWeapon){
				//Mirar en su lugar si no es una natural weapon
				return ((BasicWeapon)ataque.getWeapon()).getCategory()!=BasicWeapon.NATURAL;
				}
			}
		return false;
	}
}