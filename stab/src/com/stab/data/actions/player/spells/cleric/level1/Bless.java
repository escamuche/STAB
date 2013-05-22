package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.Bless_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Bless extends SpellOnTarget{
	
	public static final String ID="BLESS";

	@Override
	public boolean affect(Info instigator, Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int cl=getCasterLevel(caster);
		
		Bless_Buff buff = new Bless_Buff();
		buff.setTime(cl*10);
		target.addTrait(buff);
		
		return true;
		}
	
	public Bless() {
     setRange(CLOSE);
     setResource("actions/bless");
     setName("Bless");
     this.setCasterClass(StabConstants.CLERICCASTER);
     this.setEffectType(BUFF);
     this.setDescription("Bless fills your allies with courage. Each ally gains a +1 morale bonus on attack rolls and on saving throws against fear effects. Bless counters and dispels bane.");
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 10;
	}
	

}