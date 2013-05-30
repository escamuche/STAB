package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.DivineFavor_Buff;
import com.stab.model.info.BaseInfo;

public class DivineFavor extends SpellOnSelf{
	
	public static final String ID="DIVINEFAVOR";
	
	public DivineFavor() {
     setResource("actions/divinefavor");
     setName("Divine Favor");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
     this.setDescription("Calling upon the strength and wisdom of a deity, you gain a +1 luck bonus on attack and weapon damage rolls for every three caster levels you have (at least +1, maximum +3). The bonus doesn't apply to spell damage.");
     this.setLevel(1);
	}

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	int cl =getCasterLevel(caster);
	
	DivineFavor_Buff buff = new DivineFavor_Buff(cl);
	buff.setTime(10);
	target.addTrait(buff);
	return super.fullEffect(caster, target, point);
}
}