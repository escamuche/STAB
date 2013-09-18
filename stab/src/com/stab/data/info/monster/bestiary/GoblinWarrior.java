package com.stab.data.info.monster.bestiary;

import com.stab.data.StabInit;
import com.stab.data.info.ai.FlankAI;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.ai.actions.orders.Minion;
import com.stab.model.ai.traits.Agressor;
import com.stab.model.ai.traits.DistanceMapAI;

public class GoblinWarrior extends Goblin implements Minion {

	public static final String ID="GOBLIN_INFO";
	
	
	public GoblinWarrior() {
	
		
		setResource("goblin");
		setText("Goblin Warrior");
		
		
		this.equip(StabInit.getWeaponFactory().getWeapon("SHORTSWORD"), HumanoidGear.MAINHAND);
		this.equip(StabInit.getArmorFactory().getArmor("LIGHTLEATHER"), HumanoidGear.ARMOR);
		this.equip(StabInit.getArmorFactory().getArmor("LIGHTWOODENSHIELD"), HumanoidGear.OFFHAND);
		
		
	//	getAIParams().setLog(true);
		
		
	}
}
