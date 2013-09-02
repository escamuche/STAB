package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.spells.wizard.level0.Daze;
import com.stab.data.actions.player.spells.wizard.level0.DisruptUndead;
import com.stab.data.actions.player.spells.wizard.level0.RayFrost;
import com.stab.data.actions.player.spells.wizard.level0.Resistance_Wizard;
import com.stab.data.actions.player.spells.wizard.level1.MageArmor;
import com.stab.data.actions.player.spells.wizard.level1.TrueStrike;
import com.stab.data.info.alignment.Good;
import com.stab.data.info.alignment.Lawful;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.combat.Dodge_Feat;
import com.stab.data.info.feat.general.Alertness_Feat;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;
import com.stab.data.info.feat.general.IronWill_Feat;
import com.stab.data.info.monster.Outsider;
import com.stab.model.ai.AbstractAIPackage;

public class Couatl extends Outsider {

	public static final String ID="COUATL_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(12);
	
		this.getActionSet().addAction(Daze.ID);
		this.getActionSet().addAction(DisruptUndead.ID);
		this.getActionSet().addAction(RayFrost.ID);
		this.getActionSet().addAction(Resistance_Wizard.ID);
		this.getActionSet().addAction(MageArmor.ID);
		this.getActionSet().addAction(TrueStrike.ID);
		
		setResource("couatl");
		setText("Couatl");
	
	
		this.addTrait(new ImprovedInitiative_Feat());
		this.addTrait(new Alertness_Feat());
		this.addTrait(new Dodge_Feat());
		this.addTrait(new IronWill_Feat());
		
		this.setAttribute(StabConstants.XP,9600);
		this.setAttribute(StabConstants.STRENGHT,20);
		this.setAttribute(StabConstants.DEXTERITY,16);
		this.setAttribute(StabConstants.CONSTITUTION,20);
		this.setAttribute(StabConstants.INTELIGENCE,17);
		this.setAttribute(StabConstants.WISDOM,19);
		this.setAttribute(StabConstants.CHARISMA,17);
		this.setAttribute(StabConstants.SIZE,StabConstants.LARGE_SIZE);
		this.setAttribute(StabConstants.HITDICENUMBER, 12);
		this.setAttribute(StabConstants.WIZARDCASTER, 9);
		this.setAttribute(StabConstants.NATURALARMORMOD, 9);
		
		this.addTrait(new Lawful());
		this.addTrait(new Good());
		
//		DefaultAIPackage ai=new DefaultAIPackage();
//		ai.setLog(true);
//		this.setCurrentAI(ai);
		
		this.equip(StabInit.getWeaponFactory().getWeapon("SMALLBITE"), HumanoidGear.MAINHAND);
			
	//	this.setBloodeffEct("PARTICLE#redblood");
		
	}
}