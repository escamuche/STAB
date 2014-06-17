package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.DragonTraits;


public class Dragon extends Monster{
	
	public void init() {
		super.init();
		
		this.addTrait(new DragonTraits());
		this.setDescription("A dragon, the most magnificent of creatures");
	}

}
