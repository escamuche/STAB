package com.stab.data.actions.monster;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.Kill;
import com.stab.model.info.BaseInfo;
import com.stab.util.Roll;

public class GoblinMeleeAction extends Kill {
	
	public static final String ID="GOBLINGMELEE_ATTACK";
	
	protected String getSwingImage(BaseInfo atacante) {
		return "effects/zombieclaw";
	}
	
	@Override
	protected int getBaseDamage(BaseInfo Atacante) {
		
		return Roll.d4()+Atacante.getAttributeValue(StabConstants.DAMAGE);
	}

}