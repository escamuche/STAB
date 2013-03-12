package com.stab.data.info.feat.general;

import com.stab.data.actions.feats.SkillFocusPerception;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.BaseInfo;

public class SkillFocusPerception_Feat extends CombatFeat{
	
	public static final String ID="SKILLFOCUSPERCEPTION_FEAT";  //No se si sera necesario por ahora no lo es

	
	
	public SkillFocusPerception_Feat() {
		
	}
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		grantAction(baseInfo, SkillFocusPerception.ID);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		removeAction(baseInfo, SkillFocusPerception.ID);
	}
	
}
