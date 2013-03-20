package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.MonstrousHumanoidTraits;


public class MonstrousHumanoid extends Monster{
	
	public MonstrousHumanoid() {
		
		this.addTrait(new MonstrousHumanoidTraits());
		
	}

}
