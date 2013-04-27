package com.stab.data.adventure.everflame;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.data.info.applicable.SkillRoll;
import com.stab.model.action.ContextualAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class ClimbAction extends ContextualAction {
	
	public static final String ID="CLIMB_WAYPOINT_EVERFLAME_ACTION";

	public ClimbAction() {
		setRange(3);
		setName("Trepar");
		setResource("");
	}

	@Override
	public boolean affect(Info instigator, Info target, Point point) {

		BaseInfo character=(BaseInfo)instigator;
		ClimbWaypoint waypoint=(ClimbWaypoint)target;
		
		//Primero, triada de climb
		int dc=10;
		if (character.getParty().getBoolean("USARCUERDAS"))
			dc=dc-2;
		if (character.getParty().getBoolean("DESPACIO"))
			dc=dc-2;
		SkillRoll ck=new SkillRoll(character,StabConstants.ACROBATICS,dc);
		ck.check();
		if (ck.success()){
			//Ir al waypoint, todo bien.
			//animacion de moverse
			return true;
		}
		//Ahora bien, si fallamos, tirada de salvacion
		SavingThrowEffect st= new SavingThrowEffect(null,StabConstants.REFLEXSAVE,character);
		st.check();
		if (st.success()){
			//no pasa nada, un sustito.
			//animacion de warning, return
			return false;
		}
		//ahora viene la gracia.
		int rolled=st.getRollResult();
		//ver los distintos casos.
		
		
		
		return false;
	}
	
	
	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return true;
	}
}
