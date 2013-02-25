package com.stab.data.actions.player;

import com.stab.data.info.props.Barrel;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class Kill extends TargetAction{
	
	public static final String ID="Kill";

	@Override
	public boolean execute(Info yo, Info target) {
		
		( (Barrel) target) .die();
		return true;
	}
	
	public Kill() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_warrior_defensivestance");
	}
	

}
