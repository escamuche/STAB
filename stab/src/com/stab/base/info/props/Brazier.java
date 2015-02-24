package com.stab.base.info.props;

import com.stab.model.info.base.LightDecoration;

public class Brazier extends LightDecoration {

	public static final String ID="BRAZIER_INFO";

	
	public void init() {
		super.init();
		
		setResource("PARTICLE#decor/brazier");
		//setResource("effects/brazier");
		setText("Brazier");
		setDescription("A lit brazier, casting a dim light");
		setLightIntensity(8);
		//setLightColor(Color.orange);
	}
}
