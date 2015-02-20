package com.stab.pf.info.feat.combat;

import com.stab.model.info.BaseInfo;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.feats.Expertise;
import com.stab.pf.info.feat.CombatFeat;

public class Expertise_Feat extends CombatFeat{
	
	public static final String ID="EXPERTISE_FEAT";  //No se si sera necesario por ahora no lo es

	
	
	public Expertise_Feat() {
		
		this.addRequiredAttribute(StabConstants.INTELLIGENCE, 13);
	}
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		grantAction(baseInfo, Expertise.ID);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		removeAction(baseInfo, Expertise.ID);
	}
	
}
