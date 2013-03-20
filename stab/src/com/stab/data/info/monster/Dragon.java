package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.DragonTraits;


public class Dragon extends Monster{
	
	public Dragon() {
		
		this.addTrait(new DragonTraits());
		
	}

}
