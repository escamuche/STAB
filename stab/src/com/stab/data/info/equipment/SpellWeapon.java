package com.stab.data.info.equipment;

import com.stab.data.info.applicable.ActionEffect;

public class SpellWeapon extends OverrideWeapon {

	ActionEffect ae;
	
	public SpellWeapon() {
		
	}

	public void addEffect(ActionEffect ae) {
		this.ae=ae;
	}

}
