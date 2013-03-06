package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.info.applicable.FortitudeAttack;
import com.stab.data.info.debuff.Flare_Debuff;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Flare extends TargetAction{
	
	public static final String ID="FLARE";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacado = (BaseInfo)target;
		FortitudeAttack ataque=new FortitudeAttack(Atacado);
		
		if(ataque.hits()){
		Flare_Debuff buff = new Flare_Debuff(Atacado);
		Atacado.addTrait(buff);
		return true;
		}
		return false;
	}
	
	public Flare() {
     setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_druid_naturalperfection");
     setName("Flare");
     this.setEffectType(BUFF);
	}
}