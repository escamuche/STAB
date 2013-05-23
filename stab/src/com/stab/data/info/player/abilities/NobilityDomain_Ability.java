package com.stab.data.info.player.abilities;

import com.stab.data.actions.player.abilities.NobilityDomain;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Trait;

public class NobilityDomain_Ability extends Trait{
	
	public static final String ID="NOBILITYDOMAIN_ABILITY";

	
	
	public NobilityDomain_Ability() {
		
			}
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		grantAction(baseInfo, NobilityDomain.ID);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		removeAction(baseInfo, NobilityDomain_Ability.ID);
	}
}