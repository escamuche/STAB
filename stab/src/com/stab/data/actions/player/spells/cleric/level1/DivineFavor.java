package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.DivineFavor_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DivineFavor extends SpellOnSelf{
	
	public static final String ID="DIVINEFAVOR";
	
	public DivineFavor() {
     setResource("actions/divinefavor");
     setName("Divine Favor");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
     
	}

	@Override
	public boolean affect(Info instigator,Info receive,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		
		int cl =getCasterLevel(caster);
		
		DivineFavor_Buff buff = new DivineFavor_Buff(cl);
		buff.setTime(10);
		target.addTrait(buff);
		
		return true;
	}
}