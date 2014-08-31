package com.stab.data.info.other;

import com.stab.model.info.trait.base.activity.Activity;

public class ConcentrationActivity extends Activity {
	
	ConcentrationTarget concentrationTarget;
	
	public ConcentrationActivity() {
		setInterruptable(true);
	}
	
	public void setConcentrationTarget(ConcentrationTarget concentrationTarget) {
		this.concentrationTarget = concentrationTarget;
	}
	public ConcentrationTarget getConcentrationTarget() {
		return concentrationTarget;
	}
	
	
	
	public void conenctrate(){
		getConcentrationTarget().concentrate();
	}
	

	@Override
	public void cancelActivity() {
		super.cancelActivity();
		getConcentrationTarget().concentrationCancelled();
	}
	
}
