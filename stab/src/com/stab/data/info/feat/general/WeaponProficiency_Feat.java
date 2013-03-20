package com.stab.data.info.feat.general;

import com.stab.data.info.feat.Feat;

public class WeaponProficiency_Feat extends Feat{
	
	public static final String ID="WEAPONPROFICIENCY_FEAT";
	String weapon;
	
	
	public WeaponProficiency_Feat(String arma) {
		
		this.weapon = arma;
		
			}
	
	public String getWeapon() {
		return weapon;
	}
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
}

