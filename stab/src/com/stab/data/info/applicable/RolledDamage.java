package com.stab.data.info.applicable;

import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class RolledDamage extends Damage {

	int numberOfDice;
	int dice;
	int bonus;
	
	public RolledDamage(int dice,int amount, int type, Info instigator) {
		this(1,dice,amount,type, instigator);
	}
	public RolledDamage(int numberOfDice,int dice,int amount, int type, Info instigator) {
		super(Roll.roll(numberOfDice,dice)+amount, type, instigator);
		this.numberOfDice=numberOfDice;
		this.dice=dice;
		this.bonus=amount;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		RolledDamage d=(RolledDamage) super.clone();
		d.setAmount(Roll.roll(numberOfDice,dice)+bonus);
		return d;
	}

}
