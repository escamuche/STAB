package com.stab.pf.info.monster;

import com.stab.pf.info.monster.monstertraits.PlantTraits;


public class Plant extends Monster{
	
	public void init() {
		super.init();
		
		this.addTrait(new PlantTraits());
		this.setDescription("Some unnatural plant");
	}

}