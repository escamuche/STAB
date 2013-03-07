package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.ClericActionSet;
import com.stab.data.actions.player.DefendAction;
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
		this.setAttribute(StabConstants.DC,14);
		this.setAttribute(StabConstants.STRENGHT, 12);
		this.setAttribute(StabConstants.CONSTITUTION, 14);
		this.setAttribute(StabConstants.CHARISMA, 12);
		this.setAttribute(StabConstants.WISDOM, 16);
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		this.setAttribute(StabConstants.WILLSAVE, 2);
		
		this.addTrait(Modifier.createMod(StabConstants.ARMOR,"ARMADURA",3));
		this.addTrait(Modifier.createMod(StabConstants.ARMOR,"SHIELD",2));
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