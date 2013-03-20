package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.ClericActionSet;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.info.trait.Modifier;


public class ClericCharacter extends PathfinderCharacter{

	
public static final String ID="CLERIC_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new ClericActionSet());
		setResource("tokenCleric");
		setText("Cleric1");
		
		this.setMaxHp(10);
		this.setEp(10);
		this.healFully();
		this.fillEnergy();
		this.setAttribute(StabConstants.DC,14);
		this.setAttribute(StabConstants.STRENGHT, 12);
		this.setAttribute(StabConstants.CONSTITUTION, 14);
		this.setAttribute(StabConstants.CHARISMA, 12);
		this.setAttribute(StabConstants.WISDOM, 16);
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		this.setAttribute(StabConstants.WILLSAVE, 2);
		
		this.addTrait(new Modifier(StabConstants.ARMORDEFENSE,StabConstants.ARMORMOD,3));
		this.addTrait(new Modifier(StabConstants.SHIELDDEFENSE,StabConstants.SHIELDMOD,2));
		
		this.equip(StabInit.getWeaponFactory().getWeapon("QUARTERSTAFF"), HumanoidGear.BOTHHANDS);
		
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