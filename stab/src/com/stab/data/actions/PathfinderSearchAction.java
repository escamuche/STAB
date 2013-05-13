package com.stab.data.actions;

import com.stab.data.info.applicable.DetectRoll;
import com.stab.data.info.applicable.SpotRoll;
import com.stab.model.action.base.SearchAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class PathfinderSearchAction extends SearchAction{
	
	
	public static final String ID=SearchAction.ID;

	@Override
	public float getLength(Info caster) {
		return 5; //Por defecto, por ahora
	}

	public PathfinderSearchAction() {
		this.setName("Search");
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
			
			int dc=target.getHideCheck();
			
			SpotRoll s= new SpotRoll(i,dc);
			s.check();
			
			return s.success();
		}
		
		
	}

}
