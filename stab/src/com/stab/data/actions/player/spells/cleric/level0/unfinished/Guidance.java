package com.stab.data.actions.player.spells.cleric.level0.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.Guidance_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Guidance extends SpellOnTarget{
	
	public static final String ID="GUIDANCE";

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		Guidance_Buff buff = new Guidance_Buff();
		buff.setTime(10);
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}
	
	public Guidance() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
		setResource("actions/guidance");
		setName("Guidance");
		this.setEffectType(BUFF);
		this.setRange(TOUCH);
		this.setDescription("This spell imbues the subject with a touch of divine guidance. The creature gets a +1 competence bonus on a single attack roll, saving throw, or skill check. It must choose to use the bonus before making the roll to which it applies.");
		
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 3;
	}
	
}