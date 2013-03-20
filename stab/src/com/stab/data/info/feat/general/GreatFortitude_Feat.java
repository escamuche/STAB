package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class GreatFortitude_Feat extends CombatFeat{
	
	public static final String ID="GREATFORTITUDE_FEAT";

	
	
	public GreatFortitude_Feat() {
			
		Modifier save = new Modifier(StabConstants.FORTITUDESAVE, +2);
		this.addTrait(save);
	
	}
	
}