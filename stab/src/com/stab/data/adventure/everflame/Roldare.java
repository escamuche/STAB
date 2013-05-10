package com.stab.data.adventure.everflame;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.ArmorFactory;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.feat.combat.WeaponFocus_Feat;
import com.stab.data.info.feat.general.Alertness_Feat;
import com.stab.data.info.monster.Humanoid;
import com.stab.model.ai.DefaultAIPackage;

public class Roldare extends Humanoid {

	public static final String ID="ROLDARE_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		setResource("roldaretoken");
		setText("Roldare");
		setFaction(0);
		this.addTrait(new Alertness_Feat());
		//this.addTrait(new SkillFocus_FeatProfesion());
		this.addTrait(new WeaponFocus_Feat(WeaponFactory.LIGHTCROSSBOW));
		
		this.setAttribute(StabConstants.XP,400);
		this.setAttribute(StabConstants.TOHIT,+2);
		this.setAttribute(StabConstants.TOHITRANGED,+2);
		this.setAttribute(StabConstants.STRENGHT,13);
		this.setAttribute(StabConstants.DEXTERITY,14);
		this.setAttribute(StabConstants.CONSTITUTION,11);
		this.setAttribute(StabConstants.WISDOM,8);
		this.setAttribute(StabConstants.CHARISMA,9);
		this.setAttribute(StabConstants.HITDICENUMBER, 3);
		
		this.setAttribute(StabConstants.CLIMB, 7);
		this.setAttribute(StabConstants.CRAFTBOWS, 6);
		this.setAttribute(StabConstants.KNOWLEDGELOCAL, 6);
		this.setAttribute(StabConstants.PERCEPTION, 7);
		this.setAttribute(StabConstants.PROFESSIONSKILL, 8);
		this.setAttribute(StabConstants.RIDE, 8);
		this.setAttribute(StabConstants.SENSEMOTIVE, 7);
		
		DefaultAIPackage ai=new DefaultAIPackage();
		
		this.setCurrentAI(ai);
			
		this.setBloodeffEct("PARTICLE#redblood");
		
		this.equip(StabInit.getWeaponFactory().getWeapon(WeaponFactory.LIGHTCROSSBOW), HumanoidGear.MAINHAND);
		this.equip(StabInit.getArmorFactory().getArmor(ArmorFactory.PADDED), HumanoidGear.ARMOR);
		
		
		
		
	}
	
}