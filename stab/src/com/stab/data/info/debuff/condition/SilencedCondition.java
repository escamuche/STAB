package com.stab.data.info.debuff.condition;

import com.stab.data.info.applicable.SpellCasting;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.Debuff;

public class SilencedCondition extends Debuff  implements Attends<SpellCasting> {

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
