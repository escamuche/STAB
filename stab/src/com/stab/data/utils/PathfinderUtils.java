package com.stab.data.utils;

import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.data.info.buff.spells.Shield_Buff;
import com.stab.data.info.equipment.Armor;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.Shield;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.Ongoing;

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
	
	
	public static String getShieldIcon(Creature c){
		if (c.hasTrait(Shield_Buff.class))
			return "PARTICLE#mageshield";
		if (c.getEquipment(HumanoidGear.OFFHAND) instanceof Shield) {
			Shield a = (Shield)c.getEquipment(HumanoidGear.OFFHAND);
			return a.getEffectIcon();
		}
		return null;
	}
	
	
	//no iria nada mal un getWeapon() para saber que arma lleva un info (mirando mainhand, y si no lleva nada offhand), pensandose lo de las
	//armas naturales, etc.
	

	
	
	
	/**
	 * Crea un efecto de tirada de salvacion con los efectos indicados si se falla la tirada
	 * @param instigator
	 * @param target
	 * @param save
	 * @param diff
	 * @param effects
	 * @return
	 */
	public static SavingThrowEffect createST(BaseInfo instigator, BaseInfo target, String save,int diff, Applicable... effects){
		SavingThrowEffect s= new SavingThrowEffect(instigator, save, target);
		s.setTargetNumber(diff);
		for (Applicable a:effects)
			s.addApplicable(a);
		return s;
	}
	
	/**
	 * Crea un efecto de tirada de salvacion con los efectos indicados si se falla la tirada y mitad de daño si se pasa
	 * (no se aplican efectos si la tirada se evade)
	 * @param instigator
	 * @param target
	 * @param save
	 * @param diff
	 * @param effects
	 * @return
	 */
	public static SavingThrowEffect createST_Half(BaseInfo instigator, BaseInfo target, String save,int diff, Applicable... effects){
		SavingThrowEffect s= new SavingThrowEffect(instigator, save, target);
		s.setTargetNumber(diff);
		for (Applicable a:effects)
			if (a instanceof Damage)
				s.addApplicable(((Damage)a),true);
			else
				s.addApplicable(a);
		return s;
	}
	
	
	
}
