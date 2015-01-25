package com.stab.data.info.props;

import org.newdawn.slick.Color;

import com.stab.model.info.base.LightDecoration;

public class TorchStand extends LightDecoration {

	public static final String ID="WALLTORCH";

	
	public void init() {
		super.init();
		
		setResource("PARTICLE#decor/torch");
		//setResource("effects/brazier");
		setText("Torch");
		setDescription("A torch on the wall, casting a dim light");
		setLightIntensity(8);
		//setSelectable();
		//setLightColor(Color.orange);
	}
}
