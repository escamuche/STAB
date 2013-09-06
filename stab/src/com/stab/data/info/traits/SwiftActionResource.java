package com.stab.data.info.traits;

import com.stab.data.StabConstants;
import com.stab.model.info.interfaces.ActionResource;
import com.stab.model.info.trait.base.PerRoundResource;

public class SwiftActionResource extends PerRoundResource implements ActionResource{

	public static final String SWIFT_ACTION=StabConstants.SWIFT_ACTION;
	
	public SwiftActionResource() {
		super(SWIFT_ACTION,1);
	}
}
