package com.stab.data.info.equipment;

import com.stab.data.info.player.PathfinderCharacter;
import com.stab.model.action.ActionLibrary;
import com.stab.model.action.base.PickupAction;
import com.stab.model.basic.token.interfaces.Interactive;
import com.stab.model.extras.ContextualOption;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;
import com.stab.model.info.base.pickup.Inventory;
import com.stab.model.info.base.pickup.ItemPickup;

public class PathfinderItemPickup extends ItemPickup implements Interactive {
	
	public static final String ID=ItemPickup.ID;
	
	
	
	@Override
	public void init() {
		super.init();
		
		setAutoPickUp(false);
		ContextualOption d=new ContextualOption();
		//d.setAction(PickupAction.ID);
		d.setAction(ActionLibrary.getActionLibrary().getAction(PickupAction.ID));
		addExtra(d);
		
		addTag(Interactive.INTERACTIVE_TAG);
		
		
		
	}
	
	
	@Override
	public void infoPicksUp(BaseInfo info) {
		super.infoPicksUp(info);
		 if (!(info instanceof Creature))
			 return;
		 Creature c=(Creature)info;
		//Primero ver si es posible equiparlo directamente en una mano si es apropiado
		 boolean b=false;
	//	 System.out.println("Picking up "+this.getItem()+"   sugests "+this.getItem().getSlot());
		if (HumanoidGear.MAINHAND.equals(this.getItem().getSlot()) ||HumanoidGear.OFFHAND.equals(this.getItem().getSlot()) || HumanoidGear.BOTHHANDS.equals(this.getItem().getSlot()))
			if (c.getGear().isEmpty(this.getItem().getSlot())){
				b=c.equip(getItem(), this.getItem().getSlot());
			}
		
		if (b){
			this.playPickupAnimation();
			playSound("effects/equip");
			this.destroy();
			return;
		}
		
		Inventory inv=((PathfinderCharacter)info).getBasicInventory();
		 if (inv!=null){
			 if (inv.canAdd(this)){
				 this.setInventory(inv);
			 }
		 }
		 
		 playDropAnimation();
		 
	}


	@Override
	public void infoInteracts(Info actor) {
		if (actor instanceof PathfinderCharacter)
			infoPicksUp((PathfinderCharacter)actor);
	}


	@Override
	public int getDistance() {
		return 1;
	}


	@Override
	public boolean consumesAction() {
		return true;
	}

}
