package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.ClericActionSet;
import com.stab.data.actions.player.DefendAction;


public class ClericCharacter extends PathfinderCharacter{

	
public static final String ID="CLERIC_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new ClericActionSet());
		setResource("tokenCleric");
		setText("Cleric1");
		
		this.setMaxHp(10);
		this.setAttribute(StabConstants.TOHIT,2);
		this.setAttribute(StabConstants.ARMOR,15);
		this.setAttribute(StabConstants.DAMAGE,6);
		this.setAttribute(StabConstants.SAVING,5);
		this.setAttribute(StabConstants.EXPERIENCE,0);
		this.setAttribute(StabConstants.TOHITRANGED,2);
		this.setAttribute(StabConstants.DAMAGERANGED,4);
		this.setEp(10);
		this.setAttribute(StabConstants.DC,14);
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