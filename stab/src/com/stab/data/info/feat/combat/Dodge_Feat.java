package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class Dodge_Feat extends CombatFeat{
	
	public static final String ID="DODGE_FEAT";

	
	
	public Dodge_Feat() {
		
		this.addRequiredAttribute(StabConstants.DEXTERITY, 13);
		
		Modifier buff1=Modifier.createMod(StabConstants.ACTIVEDEFENSE,StabConstants.DODGEMOD,+1);
		addTrait(buff1);
		
			}
	
}
