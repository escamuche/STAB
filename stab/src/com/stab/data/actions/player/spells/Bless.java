package com.stab.data.actions.player.spells;

import com.stab.data.info.buff.Bless_Buff;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Bless extends TargetAction{
	
	public static final String ID="Bless";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacado = (BaseInfo)target;
		
		Bless_Buff buff = new Bless_Buff(Atacado);
		Atacado.addTrait(buff);
		
		return true;
		}
	
	public Bless() {
     setRange(4);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_druid_naturalperfection");
     setName("Bless");
     this.setEffectType(BUFF);
	}

	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}