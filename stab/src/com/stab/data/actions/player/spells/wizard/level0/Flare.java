package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.applicable.magic.FortitudeAttack;
import com.stab.data.info.debuff.Flare_Debuff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Flare extends SpellOnTarget{
	
	public static final String ID="FLARE";

	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
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
		
		setResource("actions/flare");
		setName("Flare");
		this.setEffectType(BUFF);
		setRange(CLOSE);
		this.setDescription("This cantrip creates a burst of light. If you cause the light to burst in front of a single creature, that creature is dazzled for 1 minute unless it makes a successful Fortitude save. Sightless creatures, as well as creatures already dazzled, are not affected by flare.");
	}
}