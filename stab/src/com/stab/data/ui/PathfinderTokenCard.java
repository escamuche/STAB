package com.stab.data.ui;

import com.stab.client.slick.base.TokenCard;
import com.stab.data.StabConstants;
import com.stab.model.basic.token.Token;

public class PathfinderTokenCard extends TokenCard {

	public static final String ID=TokenCard.ID;

	
	public void refreshData(){
		super.refreshData();
		Token t=this.getToken();
		if (t!=null){
			String ac=t.getCustomString(StabConstants.AC);
			if (ac!=null && ac.length()>0)
				this.setName(getName()+" (AC:"+ac+")");
		}
	}
	
}
