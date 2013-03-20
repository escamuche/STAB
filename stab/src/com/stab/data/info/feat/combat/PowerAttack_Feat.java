package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.actions.feats.PowerAttack;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.BaseInfo;

public class PowerAttack_Feat extends CombatFeat{
	
	public static final String ID="POWERATTACK_FEAT";

	
	
	public PowerAttack_Feat() {
		this.addRequiredAttribute(StabConstants.STRENGHT, 13);
			}
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		grantAction(baseInfo, PowerAttack.ID);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		removeAction(baseInfo, PowerAttack.ID);
	}
}
