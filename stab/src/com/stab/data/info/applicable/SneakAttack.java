package com.stab.data.info.applicable;

import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.WeaponAttack;

public class SneakAttack extends Applicable{
	
	
	public static final int NOTAVAILABLE=100;
	public static final int OUTOFRANGE=101;

	int number;
	int die;
	WeaponAttack attack;
	int range;

	
	
	public SneakAttack(Info atacante, WeaponAttack ad) {
	super(atacante);
		number=0;
		die=6;
		this.attack=ad;
		range=30;
	}


    public WeaponAttack getAttack() {
		return attack;
	}

	public void setDie(int die) {
		this.die = die;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getDie() {
		return die;
	}
	public int getNumber() {
		return number;
	}

	
	@Override
	public void ready() {
		super.ready();
		if (number<=0)
			this.setResult(NOTAVAILABLE);
	}
	@Override
	public void validate() {
		if (number<=0){
			this.setResult(NOTAVAILABLE);
			return;
		}
		
		//TODO: comprobar si podemos ver correctamente al target (ie: concealment)
		
		if (attack.isRanged())
			if (attack.getDistance()>range){
				this.setResult(OUTOFRANGE);
			}
				
	}
	
	@Override
	public boolean failed() {
		if (getResult()==NOTAVAILABLE)
			return true;
		if (getResult()==OUTOFRANGE)
			return true;
		return super.failed();
	}

}
