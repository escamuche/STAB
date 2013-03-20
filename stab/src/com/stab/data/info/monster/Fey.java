package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.FeyTraits;


public class Fey extends Monster{
	
	public Fey() {
		
		this.addTrait(new FeyTraits());
		
	}

}
