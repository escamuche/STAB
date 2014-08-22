package com.stab.data.ui;

import com.stab.client.slick.BasicActionsController;
import com.stab.common.Constants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.base.pickup.Inventory;
import com.stab.model.info.interfaces.PlayerOwned;


public class PlayerInventoryPanel extends InventoryPanel {

	BaseInfo info;
	
	@Override
	public void init() {
		super.init();
		setSize(480,512);
		setPos(Constants.END,60);
		setOpenAction(BasicActionsController.INVENTORY);
	}
	
	
	public void setInfo(BaseInfo info) {
		this.info = info;
		this.setPlayerRestricted(((PlayerOwned)info).getOwner());
		Inventory i=(Inventory)info.getTrait(Inventory.class);
		this.setInventory(i);
		refresh();

	}
	
	public BaseInfo getInfo() {
		return info;
	}
}
