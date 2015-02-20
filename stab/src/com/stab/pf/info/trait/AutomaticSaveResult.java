package com.stab.pf.info.trait;

import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.AdvancedTrait;
import com.stab.pf.info.applicable.SavingThrowEffect;

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
			if (((SavingThrowEffect)a).getSkill().equals(skill))
				return true;
		return false;
	}

	@Override
	public void attend(SavingThrowEffect app) {
	  app.setResult(result);
	  app.setReady(true);//Revisar esto quizas
	}

	
}
