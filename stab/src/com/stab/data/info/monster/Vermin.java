package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.VerminTraits;


public class Vermin extends Monster{
	
	public Vermin() {
		
		this.addTrait(new VerminTraits());
		
	}

}