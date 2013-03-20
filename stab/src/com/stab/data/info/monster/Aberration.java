package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.AberrationTraits;

public class Aberration extends Monster{
	
	public Aberration() {
		
		this.addTrait(new AberrationTraits());
		
	}

}
