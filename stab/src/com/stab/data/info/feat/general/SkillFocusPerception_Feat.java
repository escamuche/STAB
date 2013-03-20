package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class SkillFocusPerception_Feat extends Feat{
	
	public static final String ID="SKILLFOCUSPERCEPTION_FEAT";

	
	
	public SkillFocusPerception_Feat() {
		
			Modifier buff=new Modifier(StabConstants.PERCEPTION,+3);
			addTrait(buff);
		
			}
}
