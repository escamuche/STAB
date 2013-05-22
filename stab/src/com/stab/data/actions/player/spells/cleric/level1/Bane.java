package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.Bane_Debuff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Bane extends SpellOnTarget {
	
	public static final String ID="BANE";

	@Override
	public boolean affect(Info instigator, Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int cl=getCasterLevel(caster);
		
		Bane_Debuff debuff = new Bane_Debuff();
		debuff.setTime(cl*10);
		target.addTrait(debuff);
		
		return true;
		}
	
	public Bane() {
     setRange(CLOSE);
     setResource("actions/bane");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("Bane");
     this.setEffectType(DEBUFF);
     this.setDescription("Bane fills your enemies with fear and doubt. Each affected creature takes a –1 penalty on attack rolls and a –1 penalty on saving throws against fear effects. Bane counters and dispels bless.");
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
}
