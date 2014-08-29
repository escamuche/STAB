package com.stab.data.actions.player.spells.lvl0.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.interfaces.Interactive;
import com.stab.model.info.BaseInfo;

public class MageHand extends SpellOnTarget{

	public static final String ID="MAGEHAND";
	
	public MageHand() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("MageHand");
	     this.setEffectType(SPECIAL);
	     setRange(CLOSE);
	     this.setDescription("You point your finger at an object and can lift it and move it at will from a distance. As a move action, you can propel the object as far as 15 feet in any direction, though the spell ends if the distance between you and the object ever exceeds the spell's range.");
		}


@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	Interactive atacado = (Interactive)target;
	atacado.infoInteracts(caster);
	return super.fullEffect(caster, target, point);
}
}