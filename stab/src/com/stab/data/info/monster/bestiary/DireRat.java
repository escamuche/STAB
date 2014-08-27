package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.SkillFocusPerception_Feat;
import com.stab.data.info.monster.Animal;
import com.stab.model.info.trait.base.gear.Weapon;

public class DireRat extends Animal {

	public static final String ID="DIRERAT_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(8);
		
		
		setDeathSound("death/critterdeath");
		
		setResource("direrat");
		setText("Dire Rat");
		
	
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.DEXTERITY,17);
		this.setAttribute(StabConstants.CONSTITUTION,13);
		this.setAttribute(StabConstants.WISDOM,13);
		this.setAttribute(StabConstants.CHARISMA,4);
		this.setAttribute(StabConstants.SIZE,StabConstants.SMALL_SIZE);
		this.setAttribute(StabConstants.HITDICENUMBER, 1);
		
	//	this.setCurrentAI(new DefaultAIPackage());
			
		this.addTrait(new SkillFocusPerception_Feat());
		
		//falta special:Filth fever
		
	//	this.setBloodeffEct("PARTICLE#redblood");
		
		Weapon bite=StabInit.getWeaponFactory().getWeapon("SMALLBITE");
		
		this.equip(bite, HumanoidGear.MAINHAND);
		
		
	}
}