package com.stab.pf.info.feat.general;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.Feat;

public class SkillFocusPerception_Feat extends Feat{
	
	public static final String ID="SKILLFOCUSPERCEPTION_FEAT";

	
	
	public SkillFocusPerception_Feat() {
		
			Modifier buff=new Modifier(StabConstants.PERCEPTION,+3);
			addTrait(buff);
		
			}
}
