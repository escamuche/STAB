package com.stab.data.actions.player.spells.cleric.level0.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.condition.DyingCondition;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Stabilize extends SpellOnTarget{
	
	public static final String ID="STABILIZE";

	@Override
	public boolean affect(Info instigator, Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		if(target.getHp()<0){
			if(target.hasTrait(DyingCondition.ID)) {
				target.removeTrait(DyingCondition.ID);
			}
		}
		
		return false;
	}
	
	public Stabilize() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
     setRange(2);
     
     setResource("actions/ability_druid_naturalperfection");
     setName("Stabilize");
     this.setEffectType(HEAL);
	}
}