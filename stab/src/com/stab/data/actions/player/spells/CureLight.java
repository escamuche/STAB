package com.stab.data.actions.player.spells;

import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.util.Roll;

public class CureLight extends TargetAction{
	
	public static final String ID="CureLight";
	int dañobase=Roll.d8()+1;
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacado = (BaseInfo)target;
		int hpactuales = Atacado.getHp();
		
		Atacado.setHp(hpactuales+dañobase);
		
		return true;
		}
	
	public CureLight() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_rogue_imrovedrecuperate");
     setName("CureLight");
     this.setEffectType(HEAL);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}
	

}