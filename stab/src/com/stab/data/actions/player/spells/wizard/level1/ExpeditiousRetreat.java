package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.ExpeditiousRetreat_Buff;
import com.stab.model.info.BaseInfo;

public class ExpeditiousRetreat extends SpellOnSelf{
	
	public static final String ID="EXPEDITIOUSRETREAT";
	
	public ExpeditiousRetreat() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setResource("actions/expeditiousretreat");
		setName("ExpeditiousRetreat");
		this.setEffectType(BUFF);
	}

	@Override
	public boolean execute(BaseInfo self) {
		
		ExpeditiousRetreat_Buff buff = new ExpeditiousRetreat_Buff();
		buff.setTime(getCasterLevel(self)*10);
		self.addTrait(buff);
		return true;
	}
}
