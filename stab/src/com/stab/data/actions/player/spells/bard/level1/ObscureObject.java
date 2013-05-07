package com.stab.data.actions.player.spells.bard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;

public class ObscureObject extends SpellOnTarget{

	public static final String ID="OBSCUREOBJECT";
	
	public ObscureObject() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.BARDCASTER);
		 setRange(TOUCH);
	     setResource("actions/hypnotism");
	     setName("Obscure Object");
	     this.setEffectType(BUFF);
		}



}
