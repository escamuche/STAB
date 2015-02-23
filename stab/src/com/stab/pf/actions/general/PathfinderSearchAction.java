package com.stab.pf.actions.general;

import com.stab.model.action.base.SearchAction;
import com.stab.model.info.Info;

public class PathfinderSearchAction extends SearchAction{  //TODO: decidir si cambiar el extends o pasar pathfinderaction a un interfaz!
	
	
	public static final String ID=SearchAction.ID;

	@Override
	public float getLength(Info caster) {
		return 5; //Por defecto, por ahora
	}
	

	public PathfinderSearchAction() {
		this.setName("Search");
		this.setResource("actions/search");
		
	}
	
	
	
	

}
