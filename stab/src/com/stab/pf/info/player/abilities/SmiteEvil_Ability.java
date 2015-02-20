package com.stab.pf.info.player.abilities;

import com.stab.model.info.BaseInfo;
import com.stab.pf.actions.player.abilities.SmiteEvil;
import com.stab.pf.info.feat.CombatFeat;

public class SmiteEvil_Ability extends CombatFeat{
	
	public static final String ID="SMITEEVIL_ABILITY";

	
	
	public SmiteEvil_Ability() {
		
			}
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		grantAction(baseInfo, SmiteEvil.ID);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		removeAction(baseInfo, SmiteEvil.ID);
	}
}
