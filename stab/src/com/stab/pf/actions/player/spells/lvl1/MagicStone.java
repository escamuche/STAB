package com.stab.pf.actions.player.spells.lvl1;

import java.awt.Point;

import com.stab.data.actions.EffectDescriptor;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnSelf;
import com.stab.pf.info.player.PathfinderCharacter;

public class MagicStone extends SpellOnSelf{
	
	public static final String ID="MAGICSTONE";
	
	public MagicStone() {
     setResource("actions/magicstone");
     setName("MagicStone");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
     this.setDescription("You transmute as many as three pebbles, which can be no larger than sling bullets, so that they strike with great force when thrown or slung. If hurled, they have a range increment of 20 feet. If slung, treat them as sling bullets (range increment 50 feet). The spell gives them a +1 enhancement bonus on attack and damage rolls. The user of the stones makes a normal ranged attack. Each stone that hits deals 1d6+1 points of damage (including the spell's enhancement bonus), or 2d6+2 points against undead.");
     this.setLevel(1);
     this.setDescriptors(EffectDescriptor.TRANSMUTATION);
     this.setUsableByAI(false);
	}

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	
	((PathfinderCharacter)caster).addToInventory(ID);
	return super.fullEffect(caster, target, point);
}



@Override
protected void playFullEffectAnimation(BaseInfo caster, BaseInfo target,
		Point point, ActionRequest ar) {
		caster.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#effects/blueSparks");
		super.playFullEffectAnimation(caster, target, point, ar);
}
	
	
}