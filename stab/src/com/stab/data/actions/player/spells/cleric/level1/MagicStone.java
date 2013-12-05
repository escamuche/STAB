package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.MagicStone_Buff;
import com.stab.model.info.BaseInfo;

public class MagicStone extends SpellOnSelf{
	
	public static final String ID="MAGICSTONE";
	
	public MagicStone() {
     setResource("actions/magicstone");
     setName("MagicStone");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
     this.setDescription("You transmute as many as three pebbles, which can be no larger than sling bullets, so that they strike with great force when thrown or slung. If hurled, they have a range increment of 20 feet. If slung, treat them as sling bullets (range increment 50 feet). The spell gives them a +1 enhancement bonus on attack and damage rolls. The user of the stones makes a normal ranged attack. Each stone that hits deals 1d6+1 points of damage (including the spell's enhancement bonus), or 2d6+2 points against undead.");
     this.setLevel(1);
	}

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	MagicStone_Buff buff = new MagicStone_Buff();
	buff.setTime(1);
	target.addTrait(buff);
	return super.fullEffect(caster, target, point);
}
	
	
}