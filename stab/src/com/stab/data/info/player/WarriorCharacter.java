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
		this.setMaxHp(15);
		this.setAttribute(StabConstants.TOHIT,4);
		this.setAttribute(StabConstants.ARMOR,14);
		this.setAttribute(StabConstants.DAMAGE,7);
		this.setAttribute(StabConstants.SAVING,4);
		this.setAttribute(StabConstants.EXPERIENCE,0);
		
		 
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
	
