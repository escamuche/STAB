package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DetectChaos extends SelfAction{
	
	public static final String ID="DETECTCHAOS";

	
	public DetectChaos() {
     setRange(1);
     setResource("actions/bless");
     setName("Bless Water");
     this.setEffectType(SPECIAL);
	}


	@Override
	public boolean affect(Info instigator,Info receive) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		return false;
	}

	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}
