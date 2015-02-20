package com.stab.pf.info.trait;

import com.stab.model.info.interfaces.ActionResource;
import com.stab.model.info.trait.base.resource.PerRoundResource;
import com.stab.pf.StabConstants;

public class SwiftActionResource extends PerRoundResource implements ActionResource{

	public static final String SWIFT_ACTION=StabConstants.SWIFT_ACTION;
	
	public SwiftActionResource() {
		super(SWIFT_ACTION,1);
	}
}
