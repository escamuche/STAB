package com.stab.data.actions.player.spells.cleric.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.Virtue_Buff;
import com.stab.model.info.BaseInfo;

public class Virtue extends SpellOnTarget{
	
	public static final String ID="VIRTUE";

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		Virtue_Buff buff = new Virtue_Buff();
		buff.setTime(10);
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}
	
	public Virtue() {
		
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(CLOSE);
		
		setResource("actions/ability_druid_naturalperfection");
		setName("PurifyFood");
		this.setEffectType(HEAL);
		this.setDescription("With a touch, you infuse a creature with a tiny surge of life, granting the subject 1 temporary hit point.");
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
	
}