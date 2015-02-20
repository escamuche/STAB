package com.stab.pf.info.trait;

import com.stab.model.info.interfaces.ActionResource;
import com.stab.model.info.trait.base.resource.PerRoundResource;
import com.stab.pf.StabConstants;

public class AttackOfOpportunityResource  extends PerRoundResource implements ActionResource{

	public static final String AOO=StabConstants.AOO;
	
	public AttackOfOpportunityResource() {
		super(AOO,1);
	}
}
