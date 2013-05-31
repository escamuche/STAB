package com.stab.data;

import com.stab.adventure.GameLogic;
import com.stab.data.info.applicable.DetectRoll;
import com.stab.data.info.applicable.SpotRoll;
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
	
	public boolean detectAttempt(Info instigator, Info target) {
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
