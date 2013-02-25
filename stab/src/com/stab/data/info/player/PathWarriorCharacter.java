package com.stab.data.info.player;

import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.WarriorActionSet;


public class PathWarriorCharacter extends PathfinderCharacter{

	
public static final String ID="WARRIOR_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new WarriorActionSet());
		setResource("tokenWarrior");
		setText("Warrior1");
		this.setMaxHp(15);
		this.setAttribute("ToHit",4);
		this.setAttribute("Armor",14);
		this.setAttribute("Damage",7);
		this.setAttribute("Saving",4);
		this.setAttribute("Experience",0);
		
		 
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
