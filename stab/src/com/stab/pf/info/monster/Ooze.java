package com.stab.pf.info.monster;

import com.stab.pf.info.monster.monstertraits.OozeTraits;


public class Ooze extends Monster{
	
	public void init() {
		super.init();
		
		this.addTrait(new OozeTraits());
		this.setDescription("An oozing fluid that moves");
	}

}

