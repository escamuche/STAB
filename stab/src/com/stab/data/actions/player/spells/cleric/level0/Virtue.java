package com.stab.data.actions.player.spells.cleric.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.Virtue_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Virtue extends SpellOnTarget{
	
	public static final String ID="VIRTUE";

	@Override
	public boolean affect(Info instigator, Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		Virtue_Buff buff = new Virtue_Buff();
		buff.setTime(10);
		target.addTrait(buff);

		return true;
	}
	
	public Virtue() {
		
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(CLOSE);
		
		setResource("actions/ability_druid_naturalperfection");
		setName("PurifyFood");
		this.setEffectType(HEAL);
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
	
}