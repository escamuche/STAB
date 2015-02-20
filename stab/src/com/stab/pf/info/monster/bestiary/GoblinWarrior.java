package com.stab.pf.info.monster.bestiary;

import com.stab.model.ai.actions.orders.Minion;
import com.stab.pf.StabInit;
import com.stab.pf.info.equipment.HumanoidGear;

public class GoblinWarrior extends Goblin implements Minion {

	public static final String ID="GOBLIN_INFO";
	
	
	public GoblinWarrior() {
	
		
		setResource("goblin");
		setText("Goblin Warrior");
		setDescription("A better than average armed goblin");
		
		this.equip(StabInit.getWeaponFactory().getWeapon("SHORTSWORD"), HumanoidGear.MAINHAND);
		this.equip(StabInit.getArmorFactory().getArmor("LIGHTLEATHER"), HumanoidGear.ARMOR);
		this.equip(StabInit.getArmorFactory().getArmor("LIGHTWOODENSHIELD"), HumanoidGear.OFFHAND);
		
		
	//	getAIParams().setLog(true);
		
		
	}
}
