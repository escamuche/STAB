package com.stab.pf.info.monster;

import com.stab.pf.info.monster.monstertraits.HumanoidTraits;


public class Humanoid extends Monster{
	
	public void init() {
		super.init();
		this.addTrait(new HumanoidTraits());
		
	}

}
