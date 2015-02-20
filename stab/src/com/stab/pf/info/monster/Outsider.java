package com.stab.pf.info.monster;

import com.stab.pf.info.monster.monstertraits.OutsiderTraits;


public class Outsider extends Monster{
	
	public void init() {
		super.init();
		
		this.addTrait(new OutsiderTraits());
		this.setDescription("An alien, not from this plane");
	}

}