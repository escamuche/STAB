package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.OutsiderTraits;


public class Outsider extends Monster{
	
	public Outsider() {
		
		this.addTrait(new OutsiderTraits());
		
	}

}