package com.stab.data.info.equipment;

import com.stab.data.info.buff.Torchlight_Buff;

public class EquipmentFactory extends ItemFactory{
//Ya lo cambiaremos por otra clase cuando la metamos (item extends equipment, por ejemplo)
	
	
	public static final String TORCH="TORCH";
	
	
	
	public  void init(){
		
		
		Item e= new Item();
		e.setName("Torch");
		e.setSlots(HumanoidGear.OFFHAND);
		e.addTrait(new Torchlight_Buff());
		register(TORCH,e);
		
	}
	
}
