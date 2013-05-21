package com.stab.data.info.player.abilities;

import com.stab.data.actions.player.abilities.SmiteEvil;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.BaseInfo;

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
