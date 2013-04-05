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
	public boolean affect(Info instigator, Info receptor) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int cl = getCasterLevel(caster);
		
	
		FortitudeAttack ataque=new FortitudeAttack(caster);
		target.apply(ataque);
		
		if(ataque.hits()){
		Flare_Debuff buff = new Flare_Debuff();
		target.addTrait(buff);
		return true;
		}
		return false;
	}
	
	public Flare() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/flare");
		setName("Flare");
		this.setEffectType(BUFF);
		setRange(CLOSE);
		
	}
}