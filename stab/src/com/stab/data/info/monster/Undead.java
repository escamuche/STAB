package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.UndeadTraits;


public class Undead extends Monster{
	
	public void init() {
		super.init();
		
		this.addTrait(new UndeadTraits());
		
	}

}
