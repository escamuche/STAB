package com.stab.pf.info.player.abilities;

import com.stab.model.info.BaseInfo;
import com.stab.pf.actions.player.abilities.Rage;
import com.stab.pf.info.feat.CombatFeat;

public class Rage_Ability extends CombatFeat{
	
	public static final String ID="RAGE_ABILITY";

	
	
	public Rage_Ability() {
	
			}
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		grantAction(baseInfo, Rage.ID);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		removeAction(baseInfo, Rage.ID);
	}
}
