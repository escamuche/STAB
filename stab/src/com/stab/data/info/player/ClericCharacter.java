package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.ChannelPossitiveEnergyAction;
import com.stab.data.actions.player.ClericActionSet;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.abilities.NobilityDomain;
import com.stab.data.info.alignment.Evil;
import com.stab.data.info.alignment.Lawful;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.feat.combat.WeaponFocus_Feat;
import com.stab.data.info.feat.general.SelectiveChanneling_Feat;
import com.stab.data.info.player.abilities.ChannelPositiveEnergy;
import com.stab.data.info.player.abilities.NobilityDomain_Ability;
import com.stab.data.info.traits.BonusAttributeMP;
import com.stab.data.info.traits.PathfinderResource;
import com.stab.model.info.trait.base.RenewableResource;


public class ClericCharacter extends PathfinderCharacter{

	
public static final String ID="CLERIC_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new ClericActionSet());
		setResource("tokenCleric");
		setText("Cleric1");
		
		this.setMaxHp(8);
		this.setMaxEp(10);
		this.healFully();
		this.fillEnergy();
		
		this.setAttribute(StabConstants.STRENGHT, 8);
		this.setAttribute(StabConstants.DEXTERITY, 12);
		this.setAttribute(StabConstants.CONSTITUTION, 13);
		this.setAttribute(StabConstants.CHARISMA, 17);
		this.setAttribute(StabConstants.WISDOM, 14);
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		this.setAttribute(StabConstants.WILLSAVE, 2);
		this.setAttribute(StabConstants.CLERICCASTER, 1);
		
		this.setAttribute(StabConstants.APPRAISE, 4);
		this.setAttribute(StabConstants.DIPLOMACY, 7);
		this.setAttribute(StabConstants.KNOWLEDGERELIGION, 4);
		this.setAttribute(StabConstants.SPELLCRAFT, 4);
		
		this.addTrait(new WeaponFocus_Feat(WeaponFactory.LIGHTCROSSBOW));
		this.addTrait(new SelectiveChanneling_Feat());
		
		this.addTrait(new BonusAttributeMP(StabConstants.MAXMP, StabConstants.WISDOM, getValue(StabConstants.CLERICCASTER)));
		
		this.equip(StabInit.getWeaponFactory().getWeapon("LIGHTCROSSBOW"), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor("CHAINMAIL"), HumanoidGear.ARMOR);
		
		this.addTrait(new NobilityDomain_Ability());
		this.getActionSet().setAction(NobilityDomain.ID, 6);
		
		this.addTrait(new PathfinderResource(NobilityDomain.RESOURCE_ID, 5,StabConstants.WISDOM));
		
		/* Faltan habilidades especiales:
		 * Aura								ya veremos como
		 */
		
		this.addTrait(new ChannelPositiveEnergy()); 
		this.addTrait(new RenewableResource(ChannelPossitiveEnergyAction.RESOURCE_ID, 3)); 
		//En un futuro, sacar a una clase, para que pueda recalcularse el max cuando rest
		this.getActionSet().setAction(ChannelPossitiveEnergyAction.ID, 6);
		
		this.addTrait(new Lawful());
		this.addTrait(new Evil());
		
	}
	
	
	@Override
	public void setResource(String resource) {
		super.setResource(resource);
	}
	

	
	@Override
	public String getDefaultActionID() {
		return DefendAction.ID;
	}
	
}