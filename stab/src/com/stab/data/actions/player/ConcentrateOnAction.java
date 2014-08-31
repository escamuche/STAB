package com.stab.data.actions.player;

import java.awt.Point;

import com.stab.annotations.Instanced;
import com.stab.data.info.other.ConcentrationActivity;
import com.stab.model.action.Action;
import com.stab.model.action.ContextualAction;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

@Instanced
public class ConcentrateOnAction extends ContextualAction{

	
	public static final String ID="CONCENTRATE_SPELL_ACTION";
	
	
	
	ConcentrationActivity concentration;
	
	public ConcentrateOnAction() {
		setRange(SELF);
	//	setTargetMode(Action.TARGET);//mirar esto bien
		setTargetMode(Action.SELF);
		setName("Concentrate");
		setResource("actions/concentrate");
		setDescription("Concentrate on an spell or activity");
		setLosType(IN_RANGE);
		setTargetInfoClass(null);
	}

	
	public void setConcentration(ConcentrationActivity concentration) {
		this.concentration = concentration;
	}
	
	public ConcentrationActivity getConcentration() {
		return concentration;
	}

	@Override
	public int affect(Info instigator, Info target, Point point,
			ActionRequest ar) {
		if (getConcentration()!=null)
			getConcentration().concentrate();
		return OK;
	}
	
}
