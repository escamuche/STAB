package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;

public class ExpeditiousRetreat extends SpellOnSelf{
	
	public static final String ID="EXPEDITIOUSRETREAT";
	
	public ExpeditiousRetreat() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setResource("actions/ability_druid_naturalperfection");
     setName("ExpeditiousRetreat");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean execute(BaseInfo arg0) {
		// falta ExpeditiousRetreat_Buff
		return false;
	}
}
