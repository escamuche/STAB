package com.stab.pf.info.monster;

import com.stab.pf.info.monster.monstertraits.MonstrousHumanoidTraits;


public class MonstrousHumanoid extends Monster{
	
	public void init() {
		super.init();
		this.addTrait(new MonstrousHumanoidTraits());
		this.setDescription("A vaguely humanoid form, of innatural form or size");
	}

}
