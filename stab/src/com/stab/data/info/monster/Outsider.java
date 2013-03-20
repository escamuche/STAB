package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.OutsiderTraits;


public class Outsider extends Monster{
	
	public void init() {
		super.init();
		
		this.addTrait(new OutsiderTraits());
		
	}

}