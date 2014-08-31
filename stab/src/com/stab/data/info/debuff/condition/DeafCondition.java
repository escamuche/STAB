package com.stab.data.info.debuff.condition;

import com.stab.common.utils.Roll;
import com.stab.data.info.spellcasting.SpellCasting;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.DebuffEffect;

public class DeafCondition  extends DebuffEffect  implements Attends<SpellCasting> {
//Esta hay que ampliarla, claro
	
	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof SpellCasting)
			return true;
		return false;
	}

	@Override
	public void attend(SpellCasting app) {
		if (app.isVerbal()){
			if (Roll.d100()<=20)
				app.setResult(SpellCasting.INDUCEDFAIL);
		}
	}

}
