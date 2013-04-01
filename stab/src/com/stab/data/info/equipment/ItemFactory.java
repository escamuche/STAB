package com.stab.data.info.equipment;

import com.stab.model.info.trait.base.TraitFactory;

public class ItemFactory extends TraitFactory{

	public Item getItem(String id){
		Object w=createObject(id);
		if (w instanceof Item)
			return (Item)w;
		//log
		return null;
	}
	
	
	
	public void register(String id, Item w) {
		super.register(id, w);
		
			if (w.getBaseItem()==null)
				w.setBaseItem(id);
			if (w.getResource()==null){
				w.setResource("items/"+w.getBaseItem());
			}
		
	}
	
}
