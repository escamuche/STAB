package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.WizardActionSet;


public class WizardCharacter extends PathfinderCharacter{

	
public static final String ID="WIZARD_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new WizardActionSet());
		setResource("tokenWizard");
		setText("Wizard1");
		
		this.setMaxHp(6);
		this.setAttribute(StabConstants.TOHIT,1);
		this.setAttribute(StabConstants.ARMOR,12);
		this.setAttribute(StabConstants.DAMAGE,3);
		this.setAttribute(StabConstants.SAVING,5);
		this.setAttribute(StabConstants.EXPERIENCE,0);
		this.setAttribute(StabConstants.TOHITRANGED,3);
		this.setAttribute(StabConstants.DAMAGERANGED,4);
		this.setEp(10);
		this.setAttribute(StabConstants.DC,15);
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