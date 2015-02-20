package com.stab.pf.info.player.abilities;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Trait;
import com.stab.pf.actions.player.abilities.ChannelPossitiveEnergyAction;

public class ChannelPositiveEnergy extends Trait {
	
	public static final String ID="CHANNEL_POSITIVE_ENERGY";

	
	
	//TODO: hacer que este trait sea compound, y añada un trait de channel energy (para los requisitos que no sean especificamente channel positive)
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		grantAction(baseInfo, ChannelPossitiveEnergyAction.ID);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		removeAction(baseInfo, ChannelPossitiveEnergyAction.ID);
	}
}
