package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class MagicWeapon extends SpellOnTarget {
	
	public static final String ID="MAGICWEAPON_WIZARD";
	
	public MagicWeapon() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(1);
     setResource("actions/ability_druid_naturalperfection");
     setName("MagicWeapon");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean affect(Info instigator, Info receptor) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		return false;
	}
}
