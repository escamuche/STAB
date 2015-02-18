package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.feat.general.SkillFocusPerception_Feat;
import com.stab.data.info.monster.Animal;

public class Wolf extends Animal {

	public static final String ID="WOLF_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(10);
		setDeathSound("death/beastdeath");
		

		
		setResource("wolf");
		setText("Wolf");
		
		this.setAttribute(StabConstants.XP,400);
		this.setAttribute(StabConstants.STRENGHT,13);
		this.setAttribute(StabConstants.DEXTERITY,15);
		this.setAttribute(StabConstants.CONSTITUTION,15);
		this.setAttribute(StabConstants.INTELLIGENCE,2);
		this.setAttribute(StabConstants.WISDOM,12);
		this.setAttribute(StabConstants.CHARISMA,6);
		this.setAttribute(StabConstants.SIZE,StabConstants.MEDIUM_SIZE);
		this.setAttribute(StabConstants.HITDICENUMBER, 2);
		
		this.setAttribute(StabConstants.NATURALARMORMOD, 2);
		this.setAttribute(StabConstants.CMB, 6);
		
		this.setAttribute(StabConstants.PERCEPTION, 8);
		this.setAttribute(StabConstants.STEALTH, 6);
		this.setAttribute(StabConstants.SURVIVAL, 1);
		
	//	this.setCurrentAI(new DefaultAIPackage());
			
		this.addTrait(new SkillFocusPerception_Feat());
		
		this.setBloodeffEct("PARTICLE#damage/redblood");
		
		//Weapon bite=StabInit.getWeaponFactory().getWeapon("MEDIUMBITE");
		
		this.equip(WeaponFactory.MEDIUMCLAW);
		
		//falta trip
		
	}
	

	
}