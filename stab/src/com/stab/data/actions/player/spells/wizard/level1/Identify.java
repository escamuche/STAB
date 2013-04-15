package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.Identify_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Identify extends SpellOnSelf{
	
	public static final String ID="IDENTIFY";
	
	public Identify() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setRange(1);
     setResource("actions/ability_druid_naturalperfection");
     setName("Identify");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean affect(Info instigator,Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receptor;
		Identify_Buff buff = new Identify_Buff();
		target.addTrait(buff);
		return true;
	
	}
}
