package com.stab.data.actions.player;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.Kill;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class ClericBasicMelee extends Kill {
	
	public static final String ID="CLERIC_ATTACK";
	
	protected String getSwingImage(BaseInfo atacante) {
		return "effects/ClericAttack";
	}
	
	public ClericBasicMelee() {
		setResource("actions/baston");
	}
		
		@Override
		protected int getTypeDamage(BaseInfo Atacante) {
			return Damage.IMPACT_DAMAGE;
			}
		
	@Override
	protected int getBaseDamage(BaseInfo Atacante) {
		
		return Roll.d8()+Atacante.getAttributeValue(StabConstants.DAMAGE);
	}
}