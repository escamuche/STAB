package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.ExpeditiousRetreat_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

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
	public boolean affect(Info instigator,Info receive) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		ExpeditiousRetreat_Buff buff = new ExpeditiousRetreat_Buff();
		buff.setTime(getCasterLevel(caster)*10);
		target.addTrait(buff);
		return true;
	}
}
