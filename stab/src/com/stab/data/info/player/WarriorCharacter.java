package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.WarriorActionSet;
import com.stab.model.info.trait.Modifier;


public class WarriorCharacter extends PathfinderCharacter{

	
public static final String ID="WARRIOR_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new WarriorActionSet());
		setResource("tokenWarrior");
		setText("Warrior1");
		
		this.setMaxHp(13);
		this.setAttribute(StabConstants.TOHIT,1);
		//this.setAttribute(StabConstants.SAVING,3);
		//this.setAttribute(StabConstants.EXPERIENCE,0);
		this.setAttribute(StabConstants.TOHITRANGED,1);
		this.setAttribute(StabConstants.DEXTERITY, 12);
		this.setAttribute(StabConstants.STRENGHT, 16);
		this.setAttribute(StabConstants.CONSTITUTION, 14);
		this.setAttribute(StabConstants.CHARISMA, 8);
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		
		this.addTrait(Modifier.createMod(StabConstants.ARMOR,"ARMADURA",4));
		this.addTrait(Modifier.createMod(StabConstants.ARMOR,"SHIELD",2));
		
		System.out.println("Dexterity: " + this.getValue(StabConstants.DEXTERITY));
		System.out.println("Armor: " + this.getValue(StabConstants.ARMOR));
		System.out.println("Tohit: "  + this.getValue(StabConstants.TOHIT));
		System.out.println("Tohitranged: " + this.getValue(StabConstants.TOHITRANGED));
		System.out.println("Damage: " + this.getValue(StabConstants.DAMAGE));
		System.out.println("Fortitude: " + this.getValue(StabConstants.FORTITUDESAVE));
		System.out.println("Reflex: " + this.getValue(StabConstants.REFLEXSAVE));
		System.out.println("Will: " + this.getValue(StabConstants.WILLSAVE));
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
	
