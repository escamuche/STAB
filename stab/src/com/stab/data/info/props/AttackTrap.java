package com.stab.data.info.props;

import com.stab.annotations.Injected;
import com.stab.data.StabConstants;
import com.stab.model.info.trait.base.gear.Weapon;

public class AttackTrap extends TriggeredActionTrap{

	public static final String ID="ATTACK_TRAP";
	
	
	@Injected
	String weapon;
	
	@Injected
	int bonus;
	
	Weapon useWeapon;
	
	@Override
	public void init() {
		super.init();
		bonus=0;
	}
	
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	
	@Override
	protected void performAction() {
		super.performAction();
		
	}

}
