package com.stab.data.info.equipment;

import com.stab.model.info.trait.Gear;
import com.stab.model.info.trait.base.Equipment;

public class HumanoidGear extends Gear {
	
	//Revisar! que los he puesto de cabeza
	
	public static final String MAINHAND="MAINHAND";
	public static final String OFFHAND="OFFHAND";
	public static final String BOTHHANDS="BOTHHANDS";
	public static final String AMMO="AMMO";
	public static final String ARMOR="ARMOR";
	public static final String BOOTS="BOOTS";
	public static final String BRACERS="BRACERS";
	public static final String GLOVES="GLOVES";
	public static final String CLOAK="CLOAK";
	public static final String HEAD="HEAD";
	public static final String NECK="NECK";
	public static final String BELT="BELT";
	public static final String LEFTRING="LEFTRING";
	public static final String RIGHTRING="RIGHTRING";
	
	public HumanoidGear() {
		setSlots(MAINHAND,OFFHAND,BOTHHANDS,AMMO,ARMOR,BOOTS,BRACERS,GLOVES,CLOAK,HEAD,NECK,BELT,LEFTRING,RIGHTRING);
	}
	
	
	@Override
	public void equip(Equipment e, String slot) {
		if (MAINHAND.equals(slot) || OFFHAND.equals(slot))
			unequip(BOTHHANDS);
		if (BOTHHANDS.equals(slot)){
			unequip(MAINHAND);
			unequip(OFFHAND);
			assign(MAINHAND,e);
			assign(OFFHAND,e);
		}
		super.equip(e, slot);
	}
	
	@Override
	public void unequip(String slot) {
		if (BOTHHANDS.equals(slot)){
			unequip(MAINHAND);
			unequip(OFFHAND);
		}
		super.unequip(slot);
	}

}
