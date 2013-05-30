package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.ShieldFaith_Buff;
import com.stab.model.info.BaseInfo;

public class ShieldFaith extends SpellOnSelf{
	
	public static final String ID="SHIELDFAITH";
	
	public ShieldFaith() {
     setResource("actions/shieldfaith");
     setName("Shield of Faith");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
     this.setDescription("This spell creates a shimmering, magical field around the target that averts and deflects attacks. The spell grants the subject a +2 deflection bonus to AC, with an additional +1 to the bonus for every six levels you have (maximum +5 deflection bonus at 18th level).");
     this.setLevel(1);
	}

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	ShieldFaith_Buff buff = new ShieldFaith_Buff();
	buff.setTime(getCasterLevel(caster)*10);
	target.addTrait(buff);
	return super.fullEffect(caster, target, point);
}
}