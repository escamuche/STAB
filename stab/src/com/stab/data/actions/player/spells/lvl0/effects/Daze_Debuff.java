package com.stab.data.actions.player.spells.lvl0.effects;

import java.awt.Color;

import com.stab.data.actions.player.spells.lvl0.Daze;
import com.stab.data.info.applicable.SpellCasting;
import com.stab.data.info.debuff.condition.DazedCondition;
import com.stab.data.info.equipment.SpellActionEffect;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.DebuffEffect;

public class Daze_Debuff extends DebuffEffect implements Attends<SpellActionEffect> {

	public Daze_Debuff() {
		DazedCondition dc= new DazedCondition();
		dc.setTime(1);
		this.addTrait(dc);
		this.setTime(10);
	}

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof SpellActionEffect)
			return true;
		return false;
	}

	@Override
	public void attend(SpellActionEffect app) {
		if (app.getAction().getId().equals(Daze.ID)){
			app.setResult(Applicable.INMUNE);
			this.getTarget().showFloatingText("INMUNE", Color.PINK);
		}
	}
	
}
