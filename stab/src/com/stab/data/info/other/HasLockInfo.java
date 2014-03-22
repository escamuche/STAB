package com.stab.data.info.other;

import com.stab.model.Injected;
import com.stab.model.basic.token.interfaces.Interactive;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.InfoModifier;

public class HasLockInfo extends InfoModifier{

	public static final String ID="HASLOCK"	;
	
	@Injected
	int dc;
	
	@Override
	protected boolean shouldAffect(Info i) {
		if (i instanceof Interactive)
			if (i instanceof BaseInfo)
				return true;
		return false;
	}
	
	@Override
	protected void affect(Info i) {
	//	System.out.println("AÑADIENDO CERROJO A "+i);
		((BaseInfo)i).addTrait(new Locked(dc));
		
	}
	
}
