package com.stab.data.info.player;

import com.stab.model.info.base.Character;
import com.stab.model.info.trait.Attribute;

public class PathfinderCharacter extends Character {
	
public static final String ID="PATH_INFO";
	
	
	@Override
	public void init() {
		super.init();
		Attribute Tohit=new Attribute("Tohit",0);
		this.addTrait(Tohit);
		Attribute Armor=new Attribute("Armor",10);
		this.addTrait(Armor);
		Attribute Damage= new Attribute("Damage",0);
		this.addTrait(Damage);
		Attribute Experience=new Attribute("Experience",0);
		this.addTrait(Experience);
		Attribute Saving=new Attribute("Saving",0);
		this.addTrait(Saving);
	    this.setMaxMovePoints(6);
	    this.setMaxActionPoints(1);
	}
	

}
