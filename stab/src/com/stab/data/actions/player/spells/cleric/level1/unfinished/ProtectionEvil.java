package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class ProtectionEvil extends SpellOnTarget{
	
	public static final String ID="PROTECTIONEVIL_CLERIC";

	@Override
	public boolean affect(Info instigator, Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		return false;
		}
	
	public ProtectionEvil() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(1);
     
     setResource("actions/ability_shaman_watershield");
     setName("Protection Evil");
     this.setEffectType(BUFF);
	}
}
