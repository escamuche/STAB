package com.stab.data.actions.player;

import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class Kill extends TargetAction{
	
	public static final String ID="Kill";

	@Override
	public boolean execute(Info yo, Info target) {
		BaseInfo aMatar = (BaseInfo)target;
		BaseInfo elqueMata = (BaseInfo)yo;
		Damage d= new Damage(elqueMata.getValue("Damage"), Damage.SLASHING_DAMAGE,yo);
		aMatar.apply(d);
	    return true;
	}
	
	public Kill() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_warrior_defensivestance");
	}
	

}
