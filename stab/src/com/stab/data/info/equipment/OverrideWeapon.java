package com.stab.data.info.equipment;

import com.stab.data.info.applicable.WeaponAttack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.base.Creature;
import com.stab.model.info.interfaces.TurnBased;

public class OverrideWeapon extends Weapon implements TurnBased {
	
	
	Weapon old;
	int charges=1;
	boolean timed=false;
	boolean onlySpendOnHit=false;
	
	public OverrideWeapon() {
	
	}

	public void setOnlySpendOnHit(boolean onlySpendOnHit) {
		this.onlySpendOnHit = onlySpendOnHit;
	}
	
	public void setOld(Weapon old) {
		this.old = old;
	}
	
	public void setCharges(int n){
		timed=false;
		charges=n;
	}
	
	public void setTime(int n){
		timed=true;
		charges=n;
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		if (old!=null)
			((Creature)baseInfo).equip(old);
		else{
			((Creature)baseInfo).unequip(this.getSlot());
		}
	}
	
	
	public void turnStarts() {
	
		if (timed){
			if (charges>0)
				charges=charges-1;
			if (charges==0){
				target.removeTrait(this);
				return;
			}
		}
	}
	
	
	@Override
	public void attackDone(WeaponAttack attack) {
		super.attackDone(attack);
		
		if (!onlySpendOnHit || (attack.hits()))	
			spend();
	}
	
	
	
	public void spend(){
		if (charges>0){
			charges=charges-1;
			if (charges==0){
				target.removeTrait(this);
				return;
			}
		}
	}
	
	

	@Override
	public void turnEnds() {
		
	}



	
}
