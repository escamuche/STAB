package com.stab.pf.info.monster;

import com.stab.pf.info.monster.monstertraits.FeyTraits;


public class Fey extends Monster{
	
	public void init() {
		super.init();
		this.addTrait(new FeyTraits());
		this.setDescription("A faerie from the primal world");
	}

}
