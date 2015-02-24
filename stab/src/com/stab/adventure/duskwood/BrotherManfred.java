package com.stab.adventure.duskwood;

import com.stab.model.ai.traits.Healer;
import com.stab.model.info.trait.base.resource.RenewableResource;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.abilities.ChannelPossitiveEnergyAction;
import com.stab.pf.actions.player.spells.cleric.level1.CureLight;
import com.stab.pf.info.equipment.ArmorFactory;
import com.stab.pf.info.equipment.WeaponFactory;
import com.stab.pf.info.monster.Humanoid;
import com.stab.pf.info.player.abilities.ChannelPositiveEnergy;

public class BrotherManfred extends Humanoid {

	public static final String ID="BROTHERMANFRED";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		
		setFaction(0);
		
		setResource("brotherManfred");
		setText("Brother Manfred");
		
		this.setAttribute(StabConstants.STRENGHT,15);
		this.setAttribute(StabConstants.DEXTERITY,14);
		this.setAttribute(StabConstants.CONSTITUTION,13);
		this.setAttribute(StabConstants.WISDOM,17);
		this.setAttribute(StabConstants.CHARISMA,14);
		this.setAttribute(StabConstants.HITDICENUMBER, 2);
		
			
		setMaxEp(30);
		
		this.getActionSet().addAction(CureLight.ID);
		
		this.addTrait(new ChannelPositiveEnergy()); 
		this.addTrait(new RenewableResource(ChannelPossitiveEnergyAction.RESOURCE_ID, 3)); 
		
		
		this.setAttribute(StabConstants.CLERICCASTER, 2);
		
		
		addTrait(new Healer());
		
		//getAIParams().setLog(true);
		
		this.equip(WeaponFactory.MORNINGSTAR);
		this.equip(ArmorFactory.CHAINMAIL);
		
	}
	
}
