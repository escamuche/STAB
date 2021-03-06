package com.stab.base.info.props;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.PressurePlate;
import com.stab.model.info.trait.base.VisualEffect;


public class TriggerPlate extends PressurePlate{

	public static String ID="PRESSUREPLATE";
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		setResource("pressureOff");
		setDescription("A section of the ground that appears to be some trigger to a mechanism");
	}
	
	
	@Override
	public void infoEnters(Info info) {
		if (this.isHiddenFrom(info)&&(info instanceof BaseInfo)){
			((BaseInfo)info).clearActions();
			info.playAnimation(VisualEffect.ALERT_ANIMATION);
		}
		super.infoEnters(info);
		
	}
	
	@Override
	public void setState(int state) {
		super.setState(state);
		if (state==ON){
			setResource("pressureOn");
			playSound("door_close");
		}
		if (state==OFF){
			setResource("pressureOff");
		}
	}
	
	
	
}
