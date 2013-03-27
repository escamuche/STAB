package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.spells.wizard.level0.RayFrost;
import com.stab.data.actions.player.spells.wizard.level1.MagicMissile;
import com.stab.data.actions.player.spells.wizard.level1.RayEnfeeblement;
import com.stab.data.actions.player.spells.wizard.level1.Shield;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.IronWill_Feat;
import com.stab.data.info.feat.general.Toughness_Feat;
import com.stab.data.info.monster.Humanoid;
import com.stab.model.ai.DefaultAIPackage;
import com.stab.model.info.trait.Modifier;

public class Lich extends Humanoid {

	public static final String ID="LICH_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
	
		this.getActionSet().addAction(RayFrost.ID);
		this.getActionSet().addAction(MagicMissile.ID);
		this.getActionSet().addAction(Shield.ID);
		this.getActionSet().addAction(RayEnfeeblement.ID);
		
		setResource("lich");
		setText("Lich");
		setFaction(2);
	
		this.addTrait(new IronWill_Feat());
		this.addTrait(new Toughness_Feat());
		
		this.setAttribute(StabConstants.XP,19200);
		this.setAttribute(StabConstants.STRENGHT,10);
		this.setAttribute(StabConstants.DEXTERITY,14);
		this.setAttribute(StabConstants.CONSTITUTION,10);
		this.setAttribute(StabConstants.INTELIGENCE,22);
		this.setAttribute(StabConstants.WISDOM,14);
		this.setAttribute(StabConstants.CHARISMA,16);
		this.setAttribute(StabConstants.SIZE,StabConstants.MEDIUM_SIZE);
		this.setAttribute(StabConstants.HITDICENUMBER, 11);
		this.setAttribute(StabConstants.CASTERLEVEL, 11);
		
		Modifier armor = new Modifier(StabConstants.ACTIVEDEFENSE,StabConstants.ARMORMOD,+4);
		Modifier nat = new Modifier(StabConstants.ACTIVEDEFENSE,StabConstants.NATURALARMORMOD,+5);
		Modifier def = new Modifier(StabConstants.PASSIVEDEFENSE,StabConstants.DEFLECTIONMOD,+2);
		
		addTrait(armor);
		addTrait(nat);
		addTrait(def);
		
		DefaultAIPackage ai=new DefaultAIPackage();
		ai.setLog(true);
		this.setCurrentAI(ai);
	
		this.equip(StabInit.getWeaponFactory().getWeapon("MEDIUMSLAM"), HumanoidGear.BOTHHANDS);
	}
}