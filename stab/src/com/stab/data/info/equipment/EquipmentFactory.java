package com.stab.data.info.equipment;

import com.stab.data.info.buff.Torchlight_Buff;
import com.stab.model.info.trait.base.gear.Item;
import com.stab.model.info.trait.base.gear.ItemFactory;

public class EquipmentFactory extends ItemFactory{

	
	
	public static final String TORCH="TORCH";
	
	
	
	public  void init(){
		
		
		Item e= new Item();
		e.setName("Torch");
		e.setSlots(HumanoidGear.OFFHAND);
		e.addTrait(new Torchlight_Buff());
		e.setWorldResource("../effects/torch");
		e.setDropSound("effects/dropWood");
		register(TORCH,e);
		
	}
	
}
