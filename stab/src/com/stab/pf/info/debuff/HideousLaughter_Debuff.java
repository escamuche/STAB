package com.stab.pf.info.debuff;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.DebuffEffect;
import com.stab.pf.StabConstants;
import com.stab.pf.info.applicable.SavingThrowEffect;

public class HideousLaughter_Debuff extends DebuffEffect {
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
