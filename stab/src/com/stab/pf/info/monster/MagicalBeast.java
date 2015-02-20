package com.stab.pf.info.monster;

import com.stab.pf.info.monster.monstertraits.MagicalBeastTraits;


public class MagicalBeast extends Monster{
	
	public void init() {
		super.init();
		this.addTrait(new MagicalBeastTraits());
		this.setDescription("A beast, twisted by magic");
	}

}
