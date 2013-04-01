package com.stab.data.info.equipment;

import com.stab.model.info.trait.base.Equipment;

public class Item extends Equipment {
	
	
	String baseItem;
	
	public Item() {
		baseItem=null;
	}
	
	
	public void setBaseItem(String baseItem) {
		this.baseItem = baseItem;
	}
	
	public String getBaseItem() {
		return baseItem;
	}
	
}
