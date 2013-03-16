package com.stab.data.info.monster;

import com.stab.data.info.BasicAttributes;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.info.base.Creature;

public class Monster extends Creature {

	
	@Override
	public void init() {
		super.init();
		
		this.addTrait(new BasicAttributes());
		this.setGear(new HumanoidGear());   //si, si, ya, ya. ya lo separaremos en varias clases por tipo de monstruo
	}
	
}
