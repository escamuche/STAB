package com.stab.pf.actions.general;

import java.awt.Point;

import com.stab.model.action.base.ProcessPathAction;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;
import com.stab.model.request.basic.ActionRequest;

public class PathfinderPathAction extends ProcessPathAction{


	//procesa la propiedad path y lo convierte en una lista de acciones de movimiento
	public static final String ID="PATH";
	
	
	
	@Override
	public int affect(Info instigator, Info target,Point point, ActionRequest ar) {
		Creature i=(Creature)instigator;
		
		if (i.getMovePoints()==0 && i.getActionPoints()>0){
			i.setMovePoints(i.getMaxMovePoints());
			i.setActionPoints(i.getActionPoints()-1);
		}
			
		return super.affect(instigator, target, point, ar);
	}
	
	public boolean shouldEndTurn(ActionRequest ar,boolean success){
		return false;
	}

	
}
