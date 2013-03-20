package com.stab.data.info.feat.itemcreation;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.ItemCreationFeat;

public class CraftRod_Feat extends ItemCreationFeat{
	
	public static final String ID="CRAFTROD_FEAT";

	
	
	public CraftRod_Feat() {
		
		this.addRequiredAttribute(StabConstants.CASTERLEVEL, 9);
			}
	
}