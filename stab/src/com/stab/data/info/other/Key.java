package com.stab.data.info.other;

import com.stab.annotations.Injected;
import com.stab.model.info.base.Pickup;
import com.stab.model.info.trait.base.KeyTrait;

public class Key extends Pickup {

	public static final String ID="KEY";
	
	@Injected 
	String key;
	
	
	@Override
	public void init() {
		super.init();
		this.setResource("key");
		this.setAutoPickUp(true);
		this.setText("Small key");
	}
	
	public void setKey(String key) {
		this.key = key;
		this.setTrait(new KeyTrait(key));
	}
}
