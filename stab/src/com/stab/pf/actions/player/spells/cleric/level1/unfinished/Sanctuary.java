package com.stab.pf.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnSelf;
import com.stab.pf.info.buff.spells.Sanctuary_Buff;

public class Sanctuary extends SpellOnSelf{
	
	public static final String ID="SANCTUARY";
	
	public Sanctuary() {
     setResource("actions/divinefavor");
     setName("Sanctuary");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
	}

	@Override
	public int affect(Info instigator, Info receptor,Point point,ActionRequest ar) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		Sanctuary_Buff buff = new Sanctuary_Buff();
		target.addTrait(buff);
		
		return OK;
	}
}
