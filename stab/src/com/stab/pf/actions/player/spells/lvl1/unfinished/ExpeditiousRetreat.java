package com.stab.pf.actions.player.spells.lvl1.unfinished;

import java.awt.Point;

import com.stab.model.info.BaseInfo;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnSelf;
import com.stab.pf.info.buff.spells.ExpeditiousRetreat_Buff;

public class ExpeditiousRetreat extends SpellOnSelf{
	
	public static final String ID="EXPEDITIOUSRETREAT";
	
	public ExpeditiousRetreat() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setResource("actions/expeditiousretreat");
		setName("ExpeditiousRetreat");
		this.setEffectType(BUFF);
		this.setDescription("This spell increases your base land speed by 30 feet. This adjustment is treated as an enhancement bonus. There is no effect on other modes of movement, such as burrow, climb, fly, or swim. As with any effect that increases your speed, this spell affects your jumping distance (see the Acrobatics skill).");
	}

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		ExpeditiousRetreat_Buff buff = new ExpeditiousRetreat_Buff();
		buff.setTime(getCasterLevel(caster)*10);
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}
}
