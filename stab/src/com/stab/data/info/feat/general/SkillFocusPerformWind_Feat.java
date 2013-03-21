package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class SkillFocusPerformWind_Feat extends Feat{
	
	public static final String ID="SKILLFOCUSPERFORMWIND_FEAT";

	
	
	public SkillFocusPerformWind_Feat() {
		
			Modifier buff=new Modifier(StabConstants.PERFORMWIND,+3);
			addTrait(buff);
		
			}
}
