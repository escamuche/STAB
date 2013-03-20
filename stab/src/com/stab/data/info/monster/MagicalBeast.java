package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.MagicalBeastTraits;


public class MagicalBeast extends Monster{
	
	public MagicalBeast() {
		
		this.addTrait(new MagicalBeastTraits());
		
	}

}
