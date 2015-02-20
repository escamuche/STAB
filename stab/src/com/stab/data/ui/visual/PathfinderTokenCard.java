package com.stab.data.ui.visual;

import com.stab.client.slick.base.DefaultTokenCard;
import com.stab.client.slick.base.TokenCard;
import com.stab.model.basic.token.Token;
import com.stab.pf.StabConstants;

public class PathfinderTokenCard extends DefaultTokenCard {

	public static final String ID=TokenCard.ID;

	
	
	protected boolean showData(Token t){
		//return true;
		return t.getFaction()==0;
	}
	
	public void refreshData(){
		super.refreshData();
		Token t=this.getToken();
		
		if (t!=null && showData(t)){
			String ac=t.getCustomString(StabConstants.MOVEMENTS);
			if (ac!=null && ac.length()>0)
				this.setName(getName()+" (MP:"+ac+")");
		}
	}
	
}
