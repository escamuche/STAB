package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.info.debuff.Daze_Debuff;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Daze extends TargetAction{
	
	public static final String ID="DAZE";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacado = (BaseInfo)target;
		
		Daze_Debuff buff = new Daze_Debuff();
		Atacado.addTrait(buff);
		
		return true;
		}
	
	public Daze() {
     setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_druid_naturalperfection");
     setName("Daze");
     this.setEffectType(BUFF);
	}
}