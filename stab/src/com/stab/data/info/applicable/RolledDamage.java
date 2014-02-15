package com.stab.data.info.applicable;

import com.stab.common.utils.Roll;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

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
		int i=(Roll.roll(numberOfDice,dice)+bonus);
		d.amount= i;
		d.finalAmount=i;
		return d;
	}
	
	public int getDice() {
		return dice;
	}
	public int getNumberOfDice() {
		return numberOfDice;
	}
	
	public int getBonus() {
		return bonus;
	}

}
