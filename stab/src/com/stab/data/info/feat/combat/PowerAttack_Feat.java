package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.actions.feats.Expertise;
import com.stab.data.actions.feats.PowerAttack;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;

public class PowerAttack_Feat extends CombatFeat{
	
	public static final String ID="POWERATTACK_FEAT";

	
	
	public PowerAttack_Feat() {
		
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
