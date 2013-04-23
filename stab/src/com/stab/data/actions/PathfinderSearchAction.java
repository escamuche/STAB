package com.stab.data.actions;

import com.stab.data.info.applicable.DetectRoll;
import com.stab.model.action.base.SearchAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class PathfinderSearchAction extends SearchAction{
	
	
	public static final String ID=SearchAction.ID;

	@Override
	public float getLength(Info caster) {
		return 10; //Por defecto, por ahora
	}

	public PathfinderSearchAction() {
		this.setName("Heal");
		this.setResource("actions/tumble");
	}
	
	
	
	@Override
	protected boolean detectAttempt(Info instigator, Info target) {
		if (!(instigator instanceof BaseInfo))
			return true; //Es algun tipo de efecto especial
		
		BaseInfo i=(BaseInfo)instigator;
		
		if (target instanceof BaseInfo){
			
			BaseInfo t= (BaseInfo)target;
			DetectRoll d= new DetectRoll(i,t);
			d.check();
			return d.success();
			
		}else{
			//Dificultad fija? detectar siempre?
			return true;
		}
		
		
	}

}
