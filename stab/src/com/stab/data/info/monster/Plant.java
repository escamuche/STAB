package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.PlantTraits;


public class Plant extends Monster{
	
	public void init() {
		super.init();
		
		this.addTrait(new PlantTraits());
		
	}

}