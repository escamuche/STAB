package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.applicable.magic.FortitudeAttack;
import com.stab.data.info.debuff.Flare_Debuff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Flare extends SpellOnTarget{
	
	public static final String ID="FLARE";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacado = (BaseInfo)target;
		FortitudeAttack ataque=new FortitudeAttack(Atacado);
		
		if(ataque.hits()){
		Flare_Debuff buff = new Flare_Debuff();
		Atacado.addTrait(buff);
		return true;
		}
		return false;
	}
	
	public Flare() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
     setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/flare");
     setName("Flare");
     this.setEffectType(BUFF);
	}
}