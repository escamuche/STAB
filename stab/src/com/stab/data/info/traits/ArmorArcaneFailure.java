package com.stab.data.info.traits;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.info.spellcasting.SpellCasting;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.Trait;

public class ArmorArcaneFailure extends Trait implements Attends<SpellCasting>{

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof SpellCasting)
			return true;
		return false;
	}

	@Override
	public void attend(SpellCasting app) {
		if (app.isSubjectToArcaneArmorFailure())
		if (app.isSomatic()){
			int fail=((BaseInfo)app.getInstigator()).getValue(StabConstants.SPELLFAILURE);
			if (Roll.d100()<=fail)
				app.setResult(SpellCasting.ARMORFAIL);
		}
	}

}
