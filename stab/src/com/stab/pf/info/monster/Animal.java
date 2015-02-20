package com.stab.pf.info.monster;

import com.stab.pf.info.monster.monstertraits.AnimalTraits;

public class Animal extends Monster{
	
	public void init() {
		super.init();
		this.addTrait(new AnimalTraits());
		this.setDescription("A wild animal");
	}

}
