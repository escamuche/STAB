package com.stab.data.info.feat.itemcreation;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.ItemCreationFeat;

public class CraftWand_Feat extends ItemCreationFeat{
	
	public static final String ID="CRAFTWAND_FEAT";

	
	
	public CraftWand_Feat() {
		
		this.addRequiredAttribute(StabConstants.CASTERLEVEL, 5);
			}
	
}