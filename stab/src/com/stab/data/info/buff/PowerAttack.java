package com.stab.data.info.buff;

import com.stab.model.info.trait.base.Buff;

public class PowerAttack extends Buff {

	public static final String ID="POWER_ATTACK_BUFF";
	
	public PowerAttack() {
		setId(ID);
		setUnique(true);
		this.setAnimIcon("");
		this.setSound("");
		this.setResource("");
		this.setName("Power attack");
	}
	
}
