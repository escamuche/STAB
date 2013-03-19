package com.stab.data.info.monster;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.Weapon;
import com.stab.data.info.feat.general.SkillFocusPerception_Feat;
import com.stab.model.ai.DefaultAIPackage;

public class DireRat extends Monster {

	public static final String ID="DIRERAT_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(8);
		setMaxHp(5);
		healFully();
		
			
		
		setResource("direrat");
		setText("Dire Rat");
		setFaction(1);
		
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.FORTITUDESAVE,+2);
		this.setAttribute(StabConstants.REFLEXSAVE,+2);
		this.setAttribute(StabConstants.INTELIGENCE,2);
		this.setAttribute(StabConstants.DEXTERITY,17);
		this.setAttribute(StabConstants.CONSTITUTION,13);
		this.setAttribute(StabConstants.WISDOM,13);
		this.setAttribute(StabConstants.CHARISMA,4);
		this.setAttribute(StabConstants.SIZE,StabConstants.SMALL_SIZE);
		
	//	Modifier size = new Modifier().createMod(StabConstants.ARMOR,StabConstants.SIZEMOD,+1);
	//	Modifier hit = new Modifier().createMod(StabConstants.TOHIT,StabConstants.SIZEMOD,+1);
	
	//	this.addTrait(size);
	//	this.addTrait(hit);

		this.setCurrentAI(new DefaultAIPackage());
			
		this.addTrait(new SkillFocusPerception_Feat());
		
		//falta special:Filth fever
		
		this.setBloodeffEct("PARTICLE#redblood");
		
		Weapon bite=StabInit.getWeaponFactory().getWeapon("SMALLBITE");
		
		this.equip(bite, HumanoidGear.MAINHAND);
	}
	
	/*@Override
	MeleeMonsterActionSet(){
		this.addAction(GoblinMeleeAction.ID);
	}*/
}