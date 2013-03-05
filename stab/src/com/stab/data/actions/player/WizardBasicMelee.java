package com.stab.data.actions.player;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.Kill;
import com.stab.model.info.BaseInfo;
import com.stab.util.Roll;

public class WizardBasicMelee extends Kill {
	
	public static final String ID="WIZARD_ATTACK";
	
	protected String getSwingImage(BaseInfo atacante) {
		return "effects/WizardAttack";
	}
	
	public WizardBasicMelee() {
		setResource("actions/baston");
	}
	
	@Override
	protected int getBaseDamage(BaseInfo Atacante) {
		
		return Roll.d4()+Atacante.getAttributeValue(StabConstants.DAMAGE);
	}

}