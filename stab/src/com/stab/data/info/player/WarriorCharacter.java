package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.WarriorActionSet;


public class WarriorCharacter extends PathfinderCharacter{

	
public static final String ID="WARRIOR_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new WarriorActionSet());
		setResource("tokenWarrior");
		setText("Warrior1");
		
		this.setMaxHp(13);
		this.setAttribute(StabConstants.TOHIT,5);
		this.setAttribute(StabConstants.ARMOR,15);
		this.setAttribute(StabConstants.DAMAGE,4);
		this.setAttribute(StabConstants.SAVING,3);
		this.setAttribute(StabConstants.EXPERIENCE,0);
		this.setAttribute(StabConstants.TOHITRANGED,3);
		this.setAttribute(StabConstants.DAMAGERANGED,4);
		
		 
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
	
