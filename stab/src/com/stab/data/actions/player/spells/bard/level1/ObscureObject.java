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
	     this.setDescription("This spell hides an object from location by divination (scrying) effects, such as the scrying spell or a crystal ball. Such an attempt automatically fails (if the divination is targeted on the object) or fails to perceive the object (if the divination is targeted on a nearby location, object, or person).");
	 
	}



}
