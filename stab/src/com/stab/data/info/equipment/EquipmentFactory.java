package com.stab.data.info.equipment;

import com.stab.model.info.trait.base.Equipment;
import com.stab.model.info.trait.base.TraitFactory;

public class EquipmentFactory extends TraitFactory{
//Ya lo cambiaremos por otra clase cuando la metamos (item extends equipment, por ejemplo)
	
	public Equipment getEwuipment(String id){
		Object w=createObject(id);
		if (w!=null)
			return (Equipment)w;
		//log
		return null;
	}
	
	public  void init(){
		super.init();
	}
	
}
