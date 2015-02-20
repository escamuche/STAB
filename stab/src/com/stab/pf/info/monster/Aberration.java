package com.stab.pf.info.monster;

import com.stab.pf.info.monster.monstertraits.AberrationTraits;

public class Aberration extends Monster{
	
	public void init() {
		super.init();
		
		this.addTrait(new AberrationTraits());
		this.setDescription("Some foul creature, its nature unknown");
	}

}
