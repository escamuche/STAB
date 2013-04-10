package com.stab.data.info.props;

import org.newdawn.slick.Color;

import com.stab.model.info.base.LightDecoration;

public class Brazier extends LightDecoration {

	public static final String ID="BRAZIER_INFO";

	
	public void init() {
		super.init();
		
		setResource("PARTICLE#brazier");
		//setResource("effects/brazier");
		setText("");
		setLightIntensity(80);
		setLightColor(Color.orange);
	}
}
