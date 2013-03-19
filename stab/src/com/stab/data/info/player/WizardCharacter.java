package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.WizardActionSet;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.Weapon;
import com.stab.data.info.equipment.traits.FlamingWeapon;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Equipment;


public class WizardCharacter extends PathfinderCharacter{

	
public static final String ID="WIZARD_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new WizardActionSet());
		setResource("tokenWizard");
		setText("Wizard1");
		
		this.setEp(10);
		this.setMaxHp(7);
		this.healFully();
		this.fillEnergy();
		this.setAttribute(StabConstants.STRENGHT, 8);
		this.setAttribute(StabConstants.CONSTITUTION, 12);
		this.setAttribute(StabConstants.DEXTERITY, 14);
		this.setAttribute(StabConstants.INTELIGENCE, 16);
		this.setAttribute(StabConstants.WILLSAVE, 2);
		
		
		this.equip(StabInit.getWeaponFactory().getWeapon("QUARTERSTAFF"), HumanoidGear.BOTHHANDS);
		
		Equipment brazalete = new Equipment();
		brazalete.setSlots(HumanoidGear.BRACERS);
		brazalete.addTrait(Modifier.createMod(StabConstants.ARMORDEFENSE,StabConstants.ARMORMOD,+4));
		this.equip(brazalete, HumanoidGear.BRACERS);
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