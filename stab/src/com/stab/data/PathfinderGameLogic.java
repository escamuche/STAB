package com.stab.data;

import com.stab.adventure.GameLogic;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class PathfinderGameLogic extends GameLogic {

	
	@Override
	public void hide(Info i, int check) {
		super.hide(i, check);
		if (i instanceof BaseInfo){
			((BaseInfo)i).setAttribute(StabConstants.PERCEPTION_DC,check);
		}
	}
	
}
