package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.AnimalTraits;

public class Animal extends Monster{
	
	public void init() {
		super.init();
		this.addTrait(new AnimalTraits());
		
	}

}
