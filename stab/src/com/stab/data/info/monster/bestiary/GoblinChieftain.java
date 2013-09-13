package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.ai.FlankAI;
import com.stab.data.info.equipment.ArmorFactory;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.model.ai.actions.orders.Commander;
import com.stab.model.ai.traits.Agressor;
import com.stab.model.ai.traits.DistanceMapAI;

public class GoblinChieftain extends Goblin implements Commander{

	public static final String ID="GOBLIN_CHIEFTAIN_INFO";
	
	
	public GoblinChieftain() {
	
		
		setResource("goblinChief");
		setText("Goblin Chieftain");
		
		this.setAttribute(StabConstants.HITDICENUMBER, 2);
		this.setAttribute(StabConstants.STRENGHT,14);
		this.setAttribute(StabConstants.DEXTERITY,15);
		this.setAttribute(StabConstants.INTELIGENCE,14);
		this.setAttribute(StabConstants.CONSTITUTION,14);
		
		this.equip(StabInit.getWeaponFactory().getWeapon(WeaponFactory.SHORTSWORD), HumanoidGear.MAINHAND);
		this.equip(StabInit.getArmorFactory().getArmor(ArmorFactory.CHAINSHIRT), HumanoidGear.ARMOR);
		this.equip(StabInit.getArmorFactory().getArmor(ArmorFactory.LIGHTSTEELSHIELD), HumanoidGear.OFFHAND);
		
		
		this.addTrait(new Agressor());
		this.addTrait(new FlankAI(1.0f));
		this.addTrait(new DistanceMapAI());
		
		
	}


	@Override
	public int getOrderCooldown() {
	 return 2;
	}
}

