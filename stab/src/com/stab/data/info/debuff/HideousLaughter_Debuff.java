package com.stab.data.info.debuff;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Debuff;

public class HideousLaughter_Debuff extends Debuff {
	public static final String ID="HIDEOUSLAUGHTER_DEBUFF";
	
	BaseInfo i = getTarget();
	BaseInfo c=null;
	
	public HideousLaughter_Debuff(BaseInfo caster) {
		c=caster;
		
		
	}
	
	@Override
	public void turnStarts() {
		SavingThrowEffect save = new SavingThrowEffect(c, StabConstants.WILLSAVE, i);
		save.check();
		i.setTurnDone(true);
		if(save.success())
			this.end();
		super.turnStarts();
	}
}
