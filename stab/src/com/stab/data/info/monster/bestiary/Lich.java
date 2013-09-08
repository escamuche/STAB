package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.spells.wizard.level0.RayFrost;
import com.stab.data.actions.player.spells.wizard.level1.BurningHands;
import com.stab.data.actions.player.spells.wizard.level1.MagicMissile;
import com.stab.data.actions.player.spells.wizard.level1.RayEnfeeblement;
import com.stab.data.actions.player.spells.wizard.level1.Shield;
import com.stab.data.info.alignment.Evil;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.IronWill_Feat;
import com.stab.data.info.feat.general.Toughness_Feat;
import com.stab.data.info.monster.Undead;
import com.stab.model.ai.AbstractAIPackage;
import com.stab.model.info.trait.Modifier;

public class Lich extends Undead {

	public static final String ID="LICH_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
	
		setMaxEp(40);
		setEp(40);
		
		this.getActionSet().addAction(RayFrost.ID);
		this.getActionSet().addAction(MagicMissile.ID);
		this.getActionSet().addAction(Shield.ID);
		this.getActionSet().addAction(RayEnfeeblement.ID);
		this.getActionSet().addAction(BurningHands.ID);
		
		
		setResource("lich");
		setText("Lich");
		
	
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
		this.setAttribute(StabConstants.WIZARDCASTER, 11);
		
		this.addTrait(new Evil());
		
		Modifier armor = new Modifier(StabConstants.ARMORDEFENSE,StabConstants.ARMORMOD,+4);
		Modifier nat = new Modifier(StabConstants.ARMORDEFENSE,StabConstants.NATURALARMORMOD,+5);
		Modifier def = new Modifier(StabConstants.PASSIVEDEFENSE,StabConstants.DEFLECTIONMOD,+2);
		
		addTrait(armor);
		addTrait(nat);
		addTrait(def);
		
	
		getAIParams().setLog(true);
		
		this.equip(StabInit.getWeaponFactory().getWeapon("MEDIUMSLAM"), HumanoidGear.BOTHHANDS);
	}
}
