package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

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
		this.setDescription("This spell increases your base land speed by 30 feet. This adjustment is treated as an enhancement bonus. There is no effect on other modes of movement, such as burrow, climb, fly, or swim. As with any effect that increases your speed, this spell affects your jumping distance (see the Acrobatics skill).");
	}

	@Override
	public boolean affect(Info instigator,Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receptor;
		ExpeditiousRetreat_Buff buff = new ExpeditiousRetreat_Buff();
		buff.setTime(getCasterLevel(caster)*10);
		target.addTrait(buff);
		return true;
	}
}
