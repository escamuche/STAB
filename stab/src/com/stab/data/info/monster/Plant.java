package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.PlantTraits;


public class Plant extends Monster{
	
	public Plant() {
		
		this.addTrait(new PlantTraits());
		
	}

}