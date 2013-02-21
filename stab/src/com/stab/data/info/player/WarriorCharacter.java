package com.stab.data.info.player;

import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.WarriorActionSet;
import com.stab.model.info.base.Character;

public class WarriorCharacter extends Character {

	public static final String ID="WARRIOR_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new WarriorActionSet());
		setResource("tokenWarrior");
		setText("Warrior1");
		 
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
