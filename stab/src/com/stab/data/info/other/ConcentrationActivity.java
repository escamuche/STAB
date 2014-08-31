package com.stab.data.info.other;

import com.stab.model.info.interfaces.TurnBased;
import com.stab.model.info.trait.base.activity.Activity;

public class ConcentrationActivity extends Activity implements TurnBased {
	
	ConcentrationTarget concentrationTarget;
	boolean keepEveryRound=false;
	boolean done;
	
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
		done=true;
		getConcentrationTarget().concentrate();
	}
	

	@Override
	public void cancelActivity() {
		super.cancelActivity();
		getConcentrationTarget().concentrationCancelled();
	}
	
	@Override
	public void turnStarts() {
		super.turnStarts();
		done=false;
	}
	
	@Override
	public void turnEnds() {
		if (!done && isKeepEveryRound())
			this.cancelActivity();
	}
	
	public void setKeepEveryRound(boolean keepEveryRound) {
		this.keepEveryRound = keepEveryRound;
	}
	public boolean isKeepEveryRound() {
		return keepEveryRound;
	}
}
