package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.interfaces.Interactive;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class MageHand extends SpellOnTarget{

	public static final String ID="MAGEHAND";
	
	public MageHand() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("MageHand");
	     this.setEffectType(SPECIAL);
		}


	@Override
	public boolean execute(Info target, Info yo) {
		
		BaseInfo caster = (BaseInfo)yo;
		int cl = caster.getValue(StabConstants.CASTERLEVEL);
		
		setRangeClose(cl);
		Interactive atacado = (Interactive)target;
		atacado.infoInteracts(yo);
		return true;
	}
}