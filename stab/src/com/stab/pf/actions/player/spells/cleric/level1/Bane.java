package com.stab.pf.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTarget;
import com.stab.pf.info.debuff.Bane_Debuff;

public class Bane extends SpellOnTarget {
	
	public static final String ID="BANE";

@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	int cl=getCasterLevel(caster);
	
	Bane_Debuff debuff = new Bane_Debuff();
	debuff.setTime(cl*10);
	target.addTrait(debuff);
	return super.fullEffect(caster, target, point);
}
	
	public Bane() {
     setRange(CLOSE);
     setResource("actions/bane");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("Bane");
     this.setEffectType(DEBUFF);
     this.setDescription("Bane fills your enemies with fear and doubt. Each affected creature takes a –1 penalty on attack rolls and a –1 penalty on saving throws against fear effects. Bane counters and dispels bless.");
     this.setLevel(1);
	}

	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 5;
	}
}
