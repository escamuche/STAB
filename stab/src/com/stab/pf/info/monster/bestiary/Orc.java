package com.stab.pf.info.monster.bestiary;

import com.stab.model.ai.traits.Agressor;
import com.stab.model.ai.traits.DistanceMapAI;
import com.stab.model.ai.traits.SelfPreservation;
import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.info.alignment.Chaotic;
import com.stab.pf.info.alignment.Evil;
import com.stab.pf.info.equipment.ArmorFactory;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.equipment.WeaponFactory;
import com.stab.pf.info.feat.combat.WeaponFocus_Feat;
import com.stab.pf.info.monster.Humanoid;

public class Orc extends Humanoid {

	public static final String ID="ORC_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setDeathSound("death/goblindeath1");
		setResource("orc");
		setText("Orc");
		setDescription("A vicious orc, as dangerous as evil");
		this.addTrait(new WeaponFocus_Feat(WeaponFactory.GREATAXE));
		
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.TOHIT,+1);
		this.setAttribute(StabConstants.TOHITRANGED,+1);
		this.setAttribute(StabConstants.STRENGHT,17);
		this.setAttribute(StabConstants.DEXTERITY,11);
		this.setAttribute(StabConstants.CONSTITUTION,12);
		this.setAttribute(StabConstants.INTELLIGENCE,7);
		this.setAttribute(StabConstants.WISDOM,8);
		this.setAttribute(StabConstants.CHARISMA,6);
		this.setAttribute(StabConstants.HITDICENUMBER, 1);
		
		this.setAttribute(StabConstants.PERCEPTION, -1);
		this.setAttribute(StabConstants.INTIMIDATE, 2);
		
	//	DefaultAIPackage ai=new DefaultAIPackage();
	//	this.setCurrentAI(ai);
			
		this.addTrait(new Evil());
		this.addTrait(new Chaotic());
		
		
		
		this.addTrait(new SelfPreservation());
		this.addTrait(new Agressor());
	//	this.addTrait(new FlankAI(1.0f));
	//	this.addTrait(new DangerMapAI());
		this.addTrait(new DistanceMapAI());
		
		this.equip(StabInit.getWeaponFactory().getWeapon(WeaponFactory.GREATAXE), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor(ArmorFactory.STUDDEDLEATHER), HumanoidGear.ARMOR);
	}
	
}
