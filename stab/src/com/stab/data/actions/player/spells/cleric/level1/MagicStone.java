package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.MagicStone_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.request.basic.ActionRequest;

public class MagicStone extends SpellOnSelf{
	
	public static final String ID="MAGICSTONE";
	
	public MagicStone() {
     setResource("actions/magicstone");
     setName("MagicStone");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
	}

	@Override
	public boolean execute(BaseInfo yo) {
		
		BaseInfo caster = (BaseInfo)yo;
		MagicStone_Buff buff = new MagicStone_Buff();
		buff.setTime(1);
		caster.addTrait(buff);
		
		return true;
	}
	
	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return false;
	}
}