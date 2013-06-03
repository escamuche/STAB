package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.spells.cleric.level1.CureLight;
import com.stab.data.actions.player.spells.wizard.level1.MagicMissile;
import com.stab.data.info.alignment.Evil;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;
import com.stab.data.info.monster.Humanoid;
import com.stab.model.ai.DefaultAIPackage;

public class GoblinShaman extends Humanoid {

	public static final String ID="GOBLINSHAMAN_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
	
		this.getActionSet().addAction(CureLight.ID);
		this.getActionSet().addAction(MagicMissile.ID);
		
		setResource("goblinshaman");
		setText("Goblin Shaman");
		setFaction(1);
	
		this.addTrait(new ImprovedInitiative_Feat());
		
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.STRENGHT,11);
		this.setAttribute(StabConstants.DEXTERITY,15);
		this.setAttribute(StabConstants.CONSTITUTION,12);
		this.setAttribute(StabConstants.INTELIGENCE,14);
		this.setAttribute(StabConstants.WISDOM,14);
		this.setAttribute(StabConstants.CHARISMA,6);
		this.setAttribute(StabConstants.SIZE,StabConstants.SMALL_SIZE);
		this.setAttribute(StabConstants.HITDICENUMBER, 1);
		this.setAttribute(StabConstants.WIZARDCASTER, 1);
		this.setAttribute(StabConstants.CLERICCASTER, 1);
		
		DefaultAIPackage ai=new DefaultAIPackage();
	//	ai.setLog(true);
		this.setCurrentAI(ai);
			
		this.setBloodeffEct("PARTICLE#redblood");
		
		this.addTrait(new Evil());
		
		this.equip(StabInit.getWeaponFactory().getWeapon("QUARTERSTAFF"), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor("LIGHTLEATHER"), HumanoidGear.ARMOR);
		
	
		
	}
}
