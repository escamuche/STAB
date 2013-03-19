package com.stab.data.info.monster;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;
import com.stab.model.ai.DefaultAIPackage;
import com.stab.model.info.trait.Modifier;

public class Goblin extends Monster {

	public static final String ID="GOBLIN_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setMaxHp(6);
		healFully();
		
		
		
		setResource("goblin");
		setText("Goblin");
		setFaction(2);
		this.addTrait(new ImprovedInitiative_Feat());
		
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.FORTITUDESAVE,+2);
		this.setAttribute(StabConstants.TOHIT,+1);
		this.setAttribute(StabConstants.TOHITRANGED,+1);
		this.setAttribute(StabConstants.STRENGHT,11);
		this.setAttribute(StabConstants.DEXTERITY,15);
		this.setAttribute(StabConstants.CONSTITUTION,12);
		this.setAttribute(StabConstants.WISDOM,9);
		this.setAttribute(StabConstants.CHARISMA,6);
		this.setAttribute(StabConstants.SIZE,StabConstants.SMALL_SIZE);
		
		Modifier armor = new Modifier().createMod(StabConstants.ARMOR,StabConstants.ARMORMOD,+2);
		Modifier shield = new Modifier().createMod(StabConstants.ARMOR,StabConstants.SHIELDMOD,+1);
	//	Modifier size = new Modifier().createMod(StabConstants.ARMOR,StabConstants.SIZEMOD,+1);
	//	Modifier hit = new Modifier().createMod(StabConstants.TOHIT,StabConstants.SIZEMOD,+1);
	//	Modifier hitranged = new Modifier().createMod(StabConstants.TOHITRANGED,StabConstants.SIZEMOD,+1);
	
		
		this.addTrait(armor);
	//	this.addTrait(size);
	//	this.addTrait(hit);
	//	this.addTrait(hitranged);
		DefaultAIPackage ai=new DefaultAIPackage();
		
		this.setCurrentAI(ai);
			
		this.setBloodeffEct("PARTICLE#redblood");
		
		this.equip(StabInit.getWeaponFactory().getWeapon("SHORTSWORD"), HumanoidGear.MAINHAND);
		
	}
	
}