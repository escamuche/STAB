package com.stab.data.utils;

import com.stab.data.info.equipment.Armor;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.info.base.Creature;

public class PathfinderUtils {
	
	public static boolean isLightArmored(Creature c) {
		
		if (c.getEquipment(HumanoidGear.ARMOR) instanceof Armor) {
			Armor a = (Armor)c.getEquipment(HumanoidGear.ARMOR);
			if(a.getCategory()<Armor.MEDIUM_ARMOR){
				return true;
				}
			}

		else {
			
			return true;
		}
		
		return false;
		
	}
	
	
	
	
	//no iria nada mal un getWeapon() para saber que arma lleva un info (mirando mainhand, y si no lleva nada offhand), pensandose lo de las
	//armas naturales, etc.
	

}
