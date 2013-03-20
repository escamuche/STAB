package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class WeaponFocus_Feat extends CombatFeat{
	
	public static final String ID="WEAPONFOCUS_FEAT";

	
	
	public WeaponFocus_Feat() {
		
		this.addRequiredAttribute(StabConstants.BAB, 1);
		//this.addRequiredTrait(periciaarma);
		
		Modifier buff1=new Modifier(StabConstants.TOHIT,+1);
		Modifier buff2=new Modifier(StabConstants.TOHITRANGED,+1);
		addTrait(buff1);
		addTrait(buff2);
		
			}
	
}
