package com.stab.pf.info.feat.general;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class GreatFortitude_Feat extends CombatFeat{
	
	public static final String ID="GREATFORTITUDE_FEAT";

	
	
	public GreatFortitude_Feat() {
			
		Modifier save = new Modifier(StabConstants.FORTITUDESAVE, +2);
		this.addTrait(save);
	
	}
	
}