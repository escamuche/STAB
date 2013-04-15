package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.EntropicShield_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class EntropicShield extends SpellOnSelf{
	
	public static final String ID="ENTROPICSHIELD";

	
	public EntropicShield() {
     setRange(1);
     setResource("actions/bless");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("Entropic Shield");
     this.setEffectType(BUFF);
	}


	@Override
	public boolean affect(Info instigator,Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receptor;
		
			EntropicShield_Buff buff = new EntropicShield_Buff();
			buff.setTime(getCasterLevel(caster)*10);
			target.addTrait(buff);
			return true;
	
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
	

}