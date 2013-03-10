package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.DivineFavor_Buff;
import com.stab.model.info.BaseInfo;

public class DivineFavor extends SpellOnSelf{
	
	public static final String ID="DIVINEFAVOR";
	
	public DivineFavor() {
     setResource("actions/divinefavor");
     setName("Divine Favor");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
	}

	@Override
	public boolean execute(BaseInfo yo) {
		
		BaseInfo caster = (BaseInfo)yo;
		DivineFavor_Buff buff = new DivineFavor_Buff(caster);
		caster.addTrait(buff);
		
		return true;
	}
}