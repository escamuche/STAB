package com.stab.data.info.traits;

import com.stab.data.StabConstants;
import com.stab.model.info.interfaces.ActionResource;
import com.stab.model.info.trait.base.PerRoundResource;

public class AttackOfOpportunityResource  extends PerRoundResource implements ActionResource{

	public static final String AOO=StabConstants.AOO;
	
	public AttackOfOpportunityResource() {
		super(AOO,1);
	}
}
