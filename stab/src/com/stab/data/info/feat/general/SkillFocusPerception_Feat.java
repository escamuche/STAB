package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;

public class SkillFocusPerception_Feat extends CombatFeat{
	
	public static final String ID="SKILLFOCUSPERCEPTION_FEAT";  //No se si sera necesario por ahora no lo es

	
	
	public SkillFocusPerception_Feat() {
			
		
			Modifier buff=Modifier.createMod(StabConstants.PERCEPTION,+3);
					
			addTrait(buff);
			
			}
		
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		grantAction(baseInfo, SkillFocusPerception_Feat.ID);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		removeAction(baseInfo, SkillFocusPerception_Feat.ID);
	}
	
}
