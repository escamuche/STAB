package com.stab.data.info.traits;

import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.AdvancedTrait;

public class AutomaticSaveResult extends AdvancedTrait  implements Attends<SavingThrowEffect>{

	
	String skill;
	
	int result;
	
	
	
	public AutomaticSaveResult(String skill, int result) {
		super();
		this.skill = skill;
		this.result = result;
	}

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof SavingThrowEffect)
			if (((SavingThrowEffect)a).getTargetSkill().equals(skill))
				return true;
		return false;
	}

	@Override
	public void attend(SavingThrowEffect app) {
	  app.setResult(result);
	}

	
}
