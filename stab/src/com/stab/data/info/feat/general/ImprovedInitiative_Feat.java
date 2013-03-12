package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;

public class ImprovedInitiative_Feat extends CombatFeat{
	
	public static final String ID="IMPROVEDINITIATIVE_FEAT";

	
	
	public ImprovedInitiative_Feat() {
		
			Modifier buff=Modifier.createMod(StabConstants.INICIATIVEMOD,+4);
			addTrait(buff);
		
			}
		
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		grantAction(baseInfo, ImprovedInitiative_Feat.ID);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		removeAction(baseInfo, ImprovedInitiative_Feat.ID);
	}
	
}
