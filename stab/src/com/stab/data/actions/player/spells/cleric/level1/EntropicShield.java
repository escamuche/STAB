package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.EntropicShield_Buff;
import com.stab.model.info.BaseInfo;

public class EntropicShield extends SpellOnSelf{
	
	public static final String ID="ENTROPICSHIELD";

	
	public EntropicShield() {
     setRange(1);
     setResource("actions/bless");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("Entropic Shield");
     this.setEffectType(BUFF);
     this.setDescription("A magical field appears around you, glowing with a chaotic blast of multicolored hues. This field deflects incoming arrows, rays, and other ranged attacks. Each ranged attack directed at you for which the attacker must make an attack roll has a 20% miss chance (similar to the effects of concealment). Other attacks that simply work at a distance are not affected.");
     this.setLevel(1);
	}


@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	EntropicShield_Buff buff = new EntropicShield_Buff();
	buff.setTime(getCasterLevel(caster)*10);
	target.addTrait(buff);
	return super.fullEffect(caster, target, point);
}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
	

}