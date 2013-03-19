package com.stab.data.info.feat.itemcreation;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.ItemCreationFeat;
import com.stab.model.info.trait.Modifier;

public class BrewPotion_Feat extends ItemCreationFeat{
	
	public static final String ID="BREWPOTION_FEAT";

	
	
	public BrewPotion_Feat() {
		
		this.addRequiredAttribute(StabConstants.CASTERLEVEL, 3);
			}
	
}