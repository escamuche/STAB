package com.stab.pf.info.feat.general;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.Feat;

public class SkillFocusPerformWind_Feat extends Feat{
	
	public static final String ID="SKILLFOCUSPERFORMWIND_FEAT";

	
	
	public SkillFocusPerformWind_Feat() {
		
			Modifier buff=new Modifier(StabConstants.PERFORMWIND,+3);
			addTrait(buff);
		
			}
}
