package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.HumanoidTraits;


public class Humanoid extends Monster{
	
	public Humanoid() {
		
		this.addTrait(new HumanoidTraits());
		
	}

}
