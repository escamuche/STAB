package com.stab.data.info.monster.Bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.SkillFocusPerception_Feat;
import com.stab.data.info.monster.Humanoid;
import com.stab.data.info.monster.Monster;
import com.stab.model.action.BasicActionSet;
import com.stab.model.ai.DefaultAIPackage;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.Modifier;

public class Kobold extends Humanoid {

	public static final String ID="KOBOLD_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setMaxHp(5);
		healFully();
		
		
		
		setResource("kobold");
		setText("Kobold");
		setFaction(1);
		
		
		this.setAttribute(StabConstants.XP,100);
		this.setAttribute(StabConstants.TOHIT,+1);
		this.setAttribute(StabConstants.TOHITRANGED,+1);
		this.setAttribute(StabConstants.STRENGHT,9);
		this.setAttribute(StabConstants.DEXTERITY,13);
		this.setAttribute(StabConstants.WISDOM,9);
		this.setAttribute(StabConstants.CHARISMA,8);
		this.setAttribute(StabConstants.SIZE,StabConstants.SMALL_SIZE);
		this.setAttribute(StabConstants.HITDICENUMBER, 1);

		Modifier natural = new Modifier().createMod(StabConstants.ARMORDEFENSE,StabConstants.NATURALARMORMOD,+1);
		
		this.addTrait(natural);
		
		this.addTrait(new SkillFocusPerception_Feat());

		this.setCurrentAI(new DefaultAIPackage());
			
		this.setBloodeffEct("PARTICLE#redblood");
		
		this.equip(StabInit.getWeaponFactory().getWeapon("SPEAR"), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor("LIGHTLEATHER"), HumanoidGear.ARMOR);
	}
}
