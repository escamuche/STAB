package com.stab.data.info.other;

import java.util.ArrayList;

import com.stab.data.actions.ConcentrateOnAction;
import com.stab.model.extras.PlayerContextualOption;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.interfaces.TurnBased;
import com.stab.model.info.trait.base.activity.Activity;

public class ConcentrationActivity extends Activity implements TurnBased {
	
	ArrayList<ConcentrationListener> listeners;
	boolean keepEveryRound=false;
	boolean done;
	PlayerContextualOption opt;
	String description;
	
	
	public ConcentrationActivity() {
		setInterruptable(true);
		listeners= new ArrayList<ConcentrationListener>();
		setResource("actions/concentrate");
		done=true; //para que se mantenga el primer round
	}
	
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		opt=new PlayerContextualOption();
		ConcentrateOnAction act= createAction();
		act.setConcentration(this);
		opt.setAction(act);
		baseInfo.addExtra(opt);
	}
	
	protected ConcentrateOnAction createAction() {
		ConcentrateOnAction a= new ConcentrateOnAction();
		a.setResource(getResource());
		a.setName(getName());
		a.setDescription(getDescription());
		return a;
	}


	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		baseInfo.removeExtra(opt);
	}
	
	public void addConcentrationListener(ConcentrationListener concentrationListener) {
		listeners.add(concentrationListener);
	}
	
	public void removeConcentrationListener(ConcentrationListener concentrationListener) {
		listeners.remove(concentrationListener);
		endIfNotActive();
	}
	
	public void endIfNotActive(){
		if (listeners.isEmpty()) //No quedan efectos asociados a esta concentracion
			this.end();
	}
	
	public void concentrate(){
		done=true;
		for (ConcentrationListener l:listeners)
			l.concentrate();
	}
	

	@Override
	public void cancelActivity() {
		super.cancelActivity();
		for (ConcentrationListener l:listeners)
			l.concentrationCancelled();
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
		endIfNotActive();
	}
	
	public void setKeepEveryRound(boolean keepEveryRound) {
		this.keepEveryRound = keepEveryRound;
	}
	public boolean isKeepEveryRound() {
		return keepEveryRound;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	
}
