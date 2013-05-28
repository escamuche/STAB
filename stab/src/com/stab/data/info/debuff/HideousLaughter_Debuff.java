package com.stab.data.info.debuff;

import com.stab.data.info.applicable.magic.WillAttack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Debuff;

public class HideousLaughter_Debuff extends Debuff {
	public static final String ID="HIDEOUSLAUGHTER_DEBUFF";
	
	BaseInfo i = getTarget();
	
	public HideousLaughter_Debuff() {
		
		
		
	}
	
	@Override
	public void turnStarts() {
		WillAttack save = new WillAttack(i);
		i.apply(save);
		if(save.hits()){
			i.setTurnDone(true);
			i.removeTrait(this);
			}
		else
			i.setTurnDone(true);
		super.turnStarts();
	}
}
