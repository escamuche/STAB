package com.stab.data.info.equipment;

import com.stab.data.animation.SwingAnimation;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.base.TraitFactory;

public class ArmorFactory extends TraitFactory{

	
	
	
	
	public Armor getArmor(String id){
		Object w=createObject(id);
		if (w!=null)
			return (Armor)w;
		//log
		return null;
	}
	
	
	
	public  void init(){
		super.init();
		
		Armor a;
		
		
		
		a=new Armor("leather armor",2,8,0,Armor.LIGHT_ARMOR);
		register("LIGHTLEATHER",a);
		
	}
	
}
