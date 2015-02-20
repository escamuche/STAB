package com.stab.pf.info.player.abilities;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Trait;
import com.stab.pf.actions.player.abilities.NobilityDomain;

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