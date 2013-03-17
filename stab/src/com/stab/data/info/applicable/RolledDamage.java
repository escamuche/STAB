package com.stab.data.info.applicable;

import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class RolledDamage extends Damage {

	public RolledDamage(int dice,int amount, int type, Info instigator) {
		super(Roll.roll(dice)+amount, type, instigator);
	}
	public RolledDamage(int numberOfDice,int dice,int amount, int type, Info instigator) {
		super(Roll.roll(numberOfDice,dice)+amount, type, instigator);
	}

}
