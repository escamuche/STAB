package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.MonstrousHumanoidTraits;


public class MonstrousHumanoid extends Monster{
	
	public void init() {
		super.init();
		this.addTrait(new MonstrousHumanoidTraits());
		
	}

}