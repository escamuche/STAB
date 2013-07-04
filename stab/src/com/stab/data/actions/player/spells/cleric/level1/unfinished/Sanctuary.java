package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.Sanctuary_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Sanctuary extends SpellOnSelf{
	
	public static final String ID="SANCTUARY";
	
	public Sanctuary() {
     setResource("actions/divinefavor");
     setName("Sanctuary");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
	}

	@Override
	public int affect(Info instigator, Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		Sanctuary_Buff buff = new Sanctuary_Buff();
		target.addTrait(buff);
		
		return OK;
	}
}
