package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Point;

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
	     setRange(CLOSE);
		}


	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		
		Interactive atacado = (Interactive)target;
		atacado.infoInteracts(caster);
		return true;
	}
}