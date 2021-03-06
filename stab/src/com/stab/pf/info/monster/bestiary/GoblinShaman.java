package com.stab.pf.info.monster.bestiary;

import com.stab.model.ai.actions.orders.Minion;
import com.stab.model.ai.traits.Healer;
import com.stab.model.info.trait.base.resource.RenewableResource;
import com.stab.pf.StabConstants;
import com.stab.pf.PfModule;
import com.stab.pf.actions.player.abilities.ChannelPossitiveEnergyAction;
import com.stab.pf.actions.player.spells.cleric.level1.CureLight;
import com.stab.pf.actions.player.spells.lvl1.MagicMissile;
import com.stab.pf.info.equipment.ArmorFactory;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.equipment.WeaponFactory;
import com.stab.pf.info.player.abilities.ChannelPositiveEnergy;

public class GoblinShaman extends Goblin  implements Minion{

	public static final String ID="GOBLINSHAMAN_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setMaxEp(30);
		setDeathSound("death/goblindeath2");
		this.getActionSet().addAction(CureLight.ID);
		this.getActionSet().addAction(MagicMissile.ID);
		
		this.addTrait(new ChannelPositiveEnergy()); 
		this.addTrait(new RenewableResource(ChannelPossitiveEnergyAction.RESOURCE_ID, 3)); 
		
		
		setResource("goblinshaman");
		setText("Goblin Shaman");
		setDescription("Some sort of goblin shaman");
		
		this.setAttribute(StabConstants.XP,200);
		this.setAttribute(StabConstants.STRENGHT,9);
		this.setAttribute(StabConstants.INTELLIGENCE,14);
		this.setAttribute(StabConstants.WISDOM,14);

		this.setAttribute(StabConstants.HITDICENUMBER, 1);
		this.setAttribute(StabConstants.WIZARDCASTER, 1);
		this.setAttribute(StabConstants.CLERICCASTER, 1);
		
		
		addTrait(new Healer());
		
		//getAIParams().setLog(true);
		
		
		this.equip(PfModule.getWeaponFactory().getWeapon(WeaponFactory.QUARTERSTAFF), HumanoidGear.BOTHHANDS);
		this.equip(PfModule.getArmorFactory().getArmor(ArmorFactory.CLOTH), HumanoidGear.ARMOR);
		
	
		
	}
}
