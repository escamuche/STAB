package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.alignment.Chaotic;
import com.stab.data.info.alignment.Evil;
import com.stab.data.info.equipment.ArmorFactory;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.feat.combat.WeaponFocus_Feat;
import com.stab.data.info.monster.Humanoid;
import com.stab.model.ai.AbstractAIPackage;

public class Orc extends Humanoid {

	public static final String ID="ORC_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		setResource("orc");
		setText("Orc");
		
		this.addTrait(new WeaponFocus_Feat(WeaponFactory.GREATAXE));
		
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.TOHIT,+1);
		this.setAttribute(StabConstants.TOHITRANGED,+1);
		this.setAttribute(StabConstants.STRENGHT,17);
		this.setAttribute(StabConstants.DEXTERITY,11);
		this.setAttribute(StabConstants.CONSTITUTION,12);
		this.setAttribute(StabConstants.INTELIGENCE,7);
		this.setAttribute(StabConstants.WISDOM,8);
		this.setAttribute(StabConstants.CHARISMA,6);
		this.setAttribute(StabConstants.HITDICENUMBER, 1);
		
		this.setAttribute(StabConstants.PERCEPTION, -1);
		this.setAttribute(StabConstants.INTIMIDATE, 2);
		
	//	DefaultAIPackage ai=new DefaultAIPackage();
	//	this.setCurrentAI(ai);
			
		this.addTrait(new Evil());
		this.addTrait(new Chaotic());
		
	
		
		this.equip(StabInit.getWeaponFactory().getWeapon(WeaponFactory.GREATAXE), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor(ArmorFactory.STUDDEDLEATHER), HumanoidGear.ARMOR);
	}
	
}
