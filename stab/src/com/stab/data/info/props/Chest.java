package com.stab.data.info.props;

import java.util.ArrayList;

import com.stab.common.Constants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.model.basic.token.Token;
import com.stab.model.info.Info;
import com.stab.model.info.base.Gadget;
import com.stab.model.info.base.pickup.Inventory;
import com.stab.model.info.base.pickup.ItemPickup;
import com.stab.model.info.trait.base.gear.Item;

public class Chest  extends Gadget {
	

public static final String ID="CHEST";

	public static final int CLOSED=ON;
	public static final int OPEN=OFF;
	
	
	Inventory inventory;
	
	public void init() {
		super.init();
		setMaxHp(30);
		setMaxEp(0);
		healFully();
		setText("Chest");
		setDescription("A sturdy wooden chest");
		setDepth(Constants.DECOR);
		setState(CLOSED);
		inventory=new Inventory();
		this.addTrait(inventory);
		
		addLoot(StabInit.getWeaponFactory().getItem(WeaponFactory.BATTLEAXE));
	}
	
	
	public void addLoot(Item it){
		ItemPickup i=(ItemPickup)getEntityManager().createElement(ItemPickup.ID);
	    i.setItem(it);
	    i.setInventory(inventory);
	}
	
	@Override
	public void infoInteracts(Info actor) {
		if (this.getState()==CLOSED){
			openChest(actor);
		}
	}
/*
	@Override
	public boolean consumesAction() {
		if (this.getState()==OPEN)
			return false;
		return true;
	}
	/**/
	
	protected void openChest(Info actor) {
		playSound("door_open");
		setState(OPEN);
		setDepth(Constants.FLOOR);
		//Volcamos todo el loot
		ArrayList<ItemPickup> items=new ArrayList<ItemPickup>();
		items.addAll(inventory.getItems());
		this.setSelectable(Token.NOT_SELECTABLE);
		for (ItemPickup i:items)
			i.setInventory(null);
	}


	@Override
		public void setState(int state) {
			super.setState(state);
			if (state==ON){
				setResource("props/closedChest");
			}
			if (state==OFF){
				setResource("props/openChest");
			}
		}
	
	


}
