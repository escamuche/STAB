package com.stab.pf.info.monster;

import com.stab.pf.info.monster.monstertraits.VerminTraits;


public class Vermin extends Monster{
	
	public static final int DEFAULT_VERMIN_FACTION=1010;
	
	public void init() {
		super.init();
		this.addTrait(new VerminTraits());
		setFaction(DEFAULT_VERMIN_FACTION);
		this.setDescription("An insectoid horror");
	}

}