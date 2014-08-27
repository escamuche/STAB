package com.stab.data.ui;

import com.stab.common.Constants;
import com.stab.model.Player;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Panel;
import com.stab.model.info.base.Creature;
import com.stab.model.info.base.pickup.Inventory;
import com.stab.model.info.base.pickup.ItemPickup;
import com.stab.model.info.interfaces.InventoryListener;

public class InventoryPanel extends ButtonPanel  implements InventoryListener{

	
	Inventory inventory;
	
	
	Panel pact;
	Button drop;
	Button equip;
	Button use;
	
	
	
	
	public void setInventory(Inventory inventory) {
		if (this.inventory!=null)
			this.inventory.removeInventoryListener(this);
		this.inventory = inventory;
		inventory.addInventoryListener(this);
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
		b.setImage("FOUR#cyan#"+i.getItemResource()+"$S");
		b.setTooltip(i.getItem().getName());
		b.setBackground("ui/nanoborder$X");
		b.setMode(Label.BANNER);
		b.setMargin(2);
		System.out.println("created button for "+i.getItem().getName());
		return b;
	}
	
	
	
	
	
	
	
	


	public void dropSelected(){
		if (getSelected() instanceof ItemPickup){
			((ItemPickup)getSelected()).setInventory(null);
			setSelected(null);
		}
				
	}

	@Override
	public void ItemRemoved(ItemPickup i) {
		refresh();
	}

	@Override
	public void ItemAdded(ItemPickup i) {
		refresh();
	}
	
}
