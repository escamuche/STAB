package com.stab.data.info.equipment;

import com.stab.data.info.applicable.WeaponAttack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.TurnBased;
import com.stab.model.info.base.Creature;
import com.stab.model.request.Request;

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
		((Creature)baseInfo).equip(old);
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
	public boolean isTurnActive() {
		return false; //DE hecho, no debe ir a la queue
	}
	
	@Override
	public Request getNextAction() {
		return null;
	}
	
	@Override
	public boolean isTurnDone() {
		return true;
	}
	@Override
	public void setActed(boolean b) {
		}

	@Override
	public void setTurnDone(boolean b) {
	}

	@Override
	public boolean hasActed() {
			return false;
	}


	@Override
	public void turnEnds() {
		
	}


	@Override
	public int getInitiative() {
		return 0;
	}


	@Override
	public Request getDefaultAction() {
		return null;
	}


	@Override
	public void rollInitiative() {
		
	}
	
}
