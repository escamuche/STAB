package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.Weapon;
import com.stab.data.info.monster.Vermin;
import com.stab.model.ai.DefaultAIPackage;

public class GiantBombardierBeetle extends Vermin {

	public static final String ID="GIANTBOMBARDIERBEETLE_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		
			
		
		setResource("bombardierbeetle");
		setText("Giant Bombardier Beetle");
		setFaction(1);
		
		this.setAttribute(StabConstants.XP,600);
		this.setAttribute(StabConstants.STRENGHT,15);
		this.setAttribute(StabConstants.DEXTERITY,10);
		this.setAttribute(StabConstants.CONSTITUTION,14);
		this.setAttribute(StabConstants.INTELIGENCE,2);
		this.setAttribute(StabConstants.WISDOM,10);
		this.setAttribute(StabConstants.CHARISMA,9);
		this.setAttribute(StabConstants.SIZE,StabConstants.MEDIUM_SIZE);
		this.setAttribute(StabConstants.HITDICENUMBER, 3);
		
		this.setAttribute(StabConstants.NATURALARMORMOD, 6);
		this.setAttribute(StabConstants.CMB, 4);
		
		this.setAttribute(StabConstants.PERCEPTION, 6);
		
		this.setCurrentAI(new DefaultAIPackage());
		
	//	this.setBloodeffEct("PARTICLE#redblood");
		
		Weapon bite=StabInit.getWeaponFactory().getWeapon("MEDIUMBITE");
		
		this.equip(bite, HumanoidGear.BOTHHANDS);
		
		//falta ataque de aliento
		
	}
}