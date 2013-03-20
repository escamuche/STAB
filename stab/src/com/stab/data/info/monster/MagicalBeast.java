package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.MagicalBeastTraits;


public class MagicalBeast extends Monster{
	
	public void init() {
		super.init();
		this.addTrait(new MagicalBeastTraits());
		
	}

}
