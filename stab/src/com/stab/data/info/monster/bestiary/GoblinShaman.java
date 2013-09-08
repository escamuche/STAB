package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.ChannelPossitiveEnergyAction;
import com.stab.data.actions.player.spells.cleric.level1.CureLight;
import com.stab.data.actions.player.spells.wizard.level1.MagicMissile;
import com.stab.data.info.alignment.Evil;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;
import com.stab.data.info.monster.Humanoid;
import com.stab.data.info.player.abilities.ChannelPositiveEnergy;
import com.stab.model.ai.AbstractAIPackage;
import com.stab.model.info.trait.base.RenewableResource;

public class GoblinShaman extends Goblin {

	public static final String ID="GOBLINSHAMAN_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
	
		this.getActionSet().addAction(CureLight.ID);
		this.getActionSet().addAction(MagicMissile.ID);
		
		this.addTrait(new ChannelPositiveEnergy()); 
		this.addTrait(new RenewableResource(ChannelPossitiveEnergyAction.RESOURCE_ID, 3)); 
		
		
		setResource("goblinshaman");
		setText("Goblin Shaman");
		
		this.addTrait(new ImprovedInitiative_Feat());
		
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.STRENGHT,11);
		this.setAttribute(StabConstants.DEXTERITY,15);
		this.setAttribute(StabConstants.CONSTITUTION,12);
		this.setAttribute(StabConstants.INTELIGENCE,14);
		this.setAttribute(StabConstants.WISDOM,14);
		this.setAttribute(StabConstants.CHARISMA,6);
		//this.setAttribute(StabConstants.SIZE,StabConstants.SMALL_SIZE); //heredado de goblin
		this.setAttribute(StabConstants.HITDICENUMBER, 1);
		this.setAttribute(StabConstants.WIZARDCASTER, 1);
		this.setAttribute(StabConstants.CLERICCASTER, 1);
		
		
		
		getAIParams().setLog(true);
		
		this.addTrait(new Evil());
		
		this.equip(StabInit.getWeaponFactory().getWeapon("QUARTERSTAFF"), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor("LIGHTLEATHER"), HumanoidGear.ARMOR);
		
	
		
	}
}
