package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.monster.AcidFlask;
import com.stab.data.info.alignment.Chaotic;
import com.stab.data.info.equipment.ArmorFactory;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.model.ai.actions.orders.Minion;
import com.stab.model.ai.traits.PrefferRanged;

public class GoblinAlchemist  extends Goblin implements Minion{

	public static final String ID="GOBLINALCHEMIST_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setMaxEp(30);
	
	
		
		setResource("goblinAlchemist");
		setText("Goblin Alchemist");
		
		
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.DEXTERITY,15);
		this.setAttribute(StabConstants.CONSTITUTION,16);
		this.setAttribute(StabConstants.CHARISMA,6);
	
		this.setAttribute(StabConstants.HITDICENUMBER, 1);
			
		this.getActionSet().addAction(AcidFlask.ID);
		
	//	getAIParams().setLog(true);
		
		this.addTrait(new Chaotic());
		
		this.addTrait(new PrefferRanged());
		
		this.equip(StabInit.getWeaponFactory().getWeapon(WeaponFactory.DAGGER), HumanoidGear.MAINHAND);
		this.equip(StabInit.getArmorFactory().getArmor(ArmorFactory.LIGHTLEATHER), HumanoidGear.ARMOR);
		
		//this.unequip(HumanoidGear.MAINHAND);
		
	}
}
