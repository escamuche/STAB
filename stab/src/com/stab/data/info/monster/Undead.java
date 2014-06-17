package com.stab.data.info.monster;

import com.stab.data.info.monster.monstertraits.UndeadTraits;


public class Undead extends Monster{
	
	public static final int DEFAULT_UNDEAD_FACTION=1001;
	
	public void init() {
		super.init();
		this.setFaction(DEFAULT_UNDEAD_FACTION);
		this.addTrait(new UndeadTraits());
		this.setBloodeffEct("PARTICLE#damage/greenblood");
		this.setDescription("The dead walk! beware!");
	}

}
