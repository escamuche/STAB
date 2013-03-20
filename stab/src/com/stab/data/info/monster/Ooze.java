package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.OozeTraits;


public class Ooze extends Monster{
	
	public void init() {
		super.init();
		
		this.addTrait(new OozeTraits());
		
	}

}

