package com.stab.data.ui;

import com.stab.model.basic.ui.Button;
import com.stab.model.info.base.pickup.Inventory;
import com.stab.model.info.base.pickup.ItemPickup;

public class InventoryPanel extends ButtonPanel {

	
	Inventory inventory;
	
	
	
	@Override
	public void init() {
		super.init();
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
		getTitle().setText("Quick inventory");
		refresh();
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void refresh(){
		refresh(getInventory().getItems());
	}
	
	
	@Override
	protected Button createButtonFor(Object o) {
		Button b=super.createButtonFor(o);
		ItemPickup i=(ItemPickup)o;
		b.setImage(i.getItemResource()+"$S");
		b.setTooltip(i.getItem().getName());
		System.out.println("created button for "+i.getItem().getName());
		return b;
	}
	
}
