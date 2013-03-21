package com.stab.data.info.equipment;

import com.stab.data.info.buff.Torchlight_Buff;
import com.stab.model.info.trait.base.Equipment;
import com.stab.model.info.trait.base.TraitFactory;

public class EquipmentFactory extends TraitFactory{
//Ya lo cambiaremos por otra clase cuando la metamos (item extends equipment, por ejemplo)
	
	
	public static final String TORCH="TORCH";
	
	public Equipment getEquipment(String id){
		Object w=createObject(id);
		if (w!=null)
			return (Equipment)w;
		//log
		return null;
	}
	
	public  void init(){
		
		
		Equipment e= new Equipment();
		e.setName("Torch");
		e.setSlots(HumanoidGear.OFFHAND);
		e.addTrait(new Torchlight_Buff());
		register(TORCH,e);
		
	}
	
}
