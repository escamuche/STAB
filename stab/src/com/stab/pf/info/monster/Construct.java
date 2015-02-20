package com.stab.pf.info.monster;

import com.stab.pf.info.monster.monstertraits.ConstructTraits;

public class Construct extends Monster{
	
	public void init() {
		super.init();
		
		this.addTrait(new ConstructTraits());
		this.setDescription("An animated object brought to life with magic");
	}

}

