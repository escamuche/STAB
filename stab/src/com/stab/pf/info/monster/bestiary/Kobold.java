package com.stab.pf.info.monster.bestiary;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.info.alignment.Evil;
import com.stab.pf.info.alignment.Lawful;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.feat.general.SkillFocusPerception_Feat;
import com.stab.pf.info.monster.Humanoid;

public class Kobold extends Humanoid {

	public static final String ID="KOBOLD_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		
		
		setResource("kobold");
		setText("Kobold");
		setDescription("A Kobold, a common low level pest.");
			
		
		this.setAttribute(StabConstants.XP,100);
		this.setAttribute(StabConstants.TOHIT,+1);
		this.setAttribute(StabConstants.TOHITRANGED,+1);
		this.setAttribute(StabConstants.STRENGHT,9);
		this.setAttribute(StabConstants.DEXTERITY,13);
		this.setAttribute(StabConstants.WISDOM,9);
		this.setAttribute(StabConstants.CHARISMA,8);
		this.setAttribute(StabConstants.SIZE,StabConstants.SMALL_SIZE);
		this.setAttribute(StabConstants.HITDICENUMBER, 1);

		Modifier natural = new Modifier(StabConstants.ARMORDEFENSE,StabConstants.NATURALARMORMOD,+1);
		this.addTrait(natural);
		
		this.addTrait(new Evil());
		this.addTrait(new Lawful());
		
		this.addTrait(new SkillFocusPerception_Feat());

	//	this.setCurrentAI(new DefaultAIPackage());
			
		
		this.equip(StabInit.getWeaponFactory().getWeapon("SPEAR"), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor("LIGHTLEATHER"), HumanoidGear.ARMOR);
		
		
		
	}
}
