package com.stab.data.ui;

import com.stab.client.slick.BasicActionsController;
import com.stab.common.Constants;
import com.stab.model.Player;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Panel;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.base.Creature;
import com.stab.model.info.base.pickup.Inventory;
import com.stab.model.info.base.pickup.ItemPickup;
import com.stab.model.info.interfaces.PlayerOwned;


public class PlayerInventoryPanel extends InventoryPanel {

	BaseInfo info;
	
	@Override
	public void init() {
		super.init();
		setSize(480,512);
		setPos(Constants.END,60);
		setOpenAction(BasicActionsController.INVENTORY);
		pact= new Panel();
		pact.setSize(Constants.FILL,65);
		pact.setPos(Constants.BEGIN,400);
		pact.setMargins(5,5);
		pact.setGap(1, 5);
		pact.setLayout("default");
		pact.setBackground("ui/nanoborder$X");
		addChild(pact);
		createButtons();
	}
	public void createButtons(){
		drop= new Button();
		drop.setSize(145, 45);
		drop.setPos(Constants.NEXT,Constants.PREVIOUS);
		drop.addButtonListener(this);
		drop.setAction("DROP");
		drop.setActOnScene(false);
		drop.setText("DROP");
		drop.setDisabled(true);
		drop.setMode(Label.BANNER);
		pact.addChild(drop);
		
		equip= new Button();
		equip.setSize(145, 45);
		equip.setPos(Constants.NEXT,Constants.PREVIOUS);
		equip.addButtonListener(this);
		equip.setAction("EQUIP");
		equip.setActOnScene(false);
		equip.setText("EQUIP");
		equip.setDisabled(true);
		equip.setMode(Label.BANNER);
		pact.addChild(equip);
		
		use= new Button();
		use.setSize(145, 45);
		use.setPos(Constants.NEXT,Constants.PREVIOUS);
		use.addButtonListener(this);
		use.setAction("USE");
		use.setActOnScene(false);
		use.setText("USE");
		use.setDisabled(true);
		use.setMode(Label.BANNER);
		pact.addChild(use);
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
	
	@Override
	public void setSelected(Object o) {
		super.setSelected(o);
		if (getSelected() instanceof ItemPickup){
			if (getInventory()!=null)
				drop.setDisabled(!getInventory().canRemove((ItemPickup)getSelected()));
		}else{
			drop.setDisabled(true);
		}
		
		if (getSelected() instanceof ItemPickup){
			if (getInventory()!=null){
				boolean b=(getInventory().canRemove((ItemPickup)getSelected()));
				equip.setDisabled(!b);
			}
		}else{
			equip.setDisabled(true);
		}
		
		if (getSelected() instanceof ItemPickup){
			if (getInventory()!=null)
				//use.setDisabled(((ItemPickup)getSelected()));
				use.setDisabled(true);
		}else{
			use.setDisabled(true);
		}
	}
	
	@Override
	public void buttonActivated(Player p, Button b) {
		if (b==drop){
			dropSelected();
			return;
		}
		if (b==equip){
			equipSelected();
			return;
		}
		if (b==use){
			useSelected();
		}
		super.buttonActivated(p, b);
	}
	

	protected void useSelected() {
		
	}

	protected void equipSelected() {

		if (getSelected() instanceof ItemPickup){
			boolean b=((Creature)this.getInfo()).equip(((ItemPickup)getSelected()).getItem());
			if (b){
				((ItemPickup)getSelected()).destroy();
			}
		}
	}
}
