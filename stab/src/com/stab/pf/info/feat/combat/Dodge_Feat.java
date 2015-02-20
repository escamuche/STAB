package com.stab.pf.info.feat.combat;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class Dodge_Feat extends CombatFeat{
	
	public static final String ID="DODGE_FEAT";

	
	
	public Dodge_Feat() {
		
		this.addRequiredAttribute(StabConstants.DEXTERITY, 13);
		
		Modifier buff1=new Modifier(StabConstants.ACTIVEDEFENSE,StabConstants.DODGEMOD,+1);
		addTrait(buff1);
		
			}
	
}
