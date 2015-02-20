package com.stab.pf.info.debuff.condition;

import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.DebuffEffect;
import com.stab.pf.info.spellcasting.SpellCasting;

public class SilencedCondition extends DebuffEffect  implements Attends<SpellCasting> {

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof SpellCasting)
			return true;
		return false;
	}

	@Override
	public void attend(SpellCasting app) {
		if (app.isVerbal())
			app.setResult(SpellCasting.INDUCEDFAIL);
	}

}
