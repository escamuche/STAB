package com.stab.pf.info.monster.bestiary;

import com.stab.data.actions.traps.FlameJet;
import com.stab.model.info.trait.base.gear.Weapon;
import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.monster.Vermin;

public class GiantBombardierBeetle extends Vermin {

	public static final String ID="GIANTBOMBARDIERBEETLE_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		
			
		
		setResource("bombardierbeetle");
		setText("Giant Bombardier Beetle");
		
		this.setAttribute(StabConstants.XP,600);
		this.setAttribute(StabConstants.STRENGHT,15);
		this.setAttribute(StabConstants.DEXTERITY,10);
		this.setAttribute(StabConstants.CONSTITUTION,14);
		this.setAttribute(StabConstants.INTELLIGENCE,2);
		this.setAttribute(StabConstants.WISDOM,10);
		this.setAttribute(StabConstants.CHARISMA,9);
		this.setAttribute(StabConstants.SIZE,StabConstants.MEDIUM_SIZE);
		this.setAttribute(StabConstants.HITDICENUMBER, 3);
		
		this.setAttribute(StabConstants.NATURALARMORMOD, 6);
		this.setAttribute(StabConstants.CMB, 4);
		
		this.setAttribute(StabConstants.PERCEPTION, 6);
		
	//	this.setCurrentAI(new DefaultAIPackage());
		
	//	this.setBloodeffEct("PARTICLE#redblood");
		
		Weapon bite=StabInit.getWeaponFactory().getWeapon("MEDIUMBITE");
		
		this.equip(bite, HumanoidGear.BOTHHANDS);
		
		//falta ataque de aliento
		
		this.getActionSet().addAction(FlameJet.ID);
		
	}
}