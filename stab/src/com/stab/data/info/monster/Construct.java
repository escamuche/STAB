package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.ConstructTraits;

public class Construct extends Monster{
	
	public Construct() {
		
		this.addTrait(new ConstructTraits());
		
	}

}

