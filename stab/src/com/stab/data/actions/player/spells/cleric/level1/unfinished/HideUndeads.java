package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class HideUndeads extends SpellOnTarget{
	
	public static final String ID="HIDEUNDEADS";


	@Override
	public boolean affect(Info instigator, Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		return false;
		}
	
	public HideUndeads() {
     setRange(1);
     
     setResource("actions/curelightwounds");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("CureLight");
     this.setEffectType(HEAL);
	}
}