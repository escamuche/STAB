package com.stab.data.info.equipment;

import com.stab.data.actions.player.spells.DismissSpellAction;
import com.stab.model.action.ActionLibrary;
import com.stab.model.action.base.PickupAction;
import com.stab.model.extras.ContextualOption;
import com.stab.model.info.base.pickup.ItemPickup;
import com.stab.model.info.trait.base.gear.Item;
import com.stab.model.info.trait.base.gear.Weapon;

public class PathfinderItemPickup extends ItemPickup {
	
	public static final String ID=ItemPickup.ID;
	
	
	
	@Override
	public void init() {
		super.init();
		
		setAutoPickUp(false);
		ContextualOption d=new ContextualOption();
		d.setAction(PickupAction.ID);
		addExtra(d);
		
	}
	
	
	@Override
	public void setItem(Item item) {
		super.setItem(item);
		if (item instanceof Weapon){
			Weapon w=((Weapon)item);
			setResource("../"+w.getAnimationIcon());
		}
	}

}
