package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.model.info.base.Character;
import com.stab.model.info.trait.Attribute;

public class PathfinderCharacter extends Character {
	
public static final String ID="PATH_INFO";
	
	
	@Override
	public void init() {
		super.init();
		Attribute Tohit=new Attribute(StabConstants.TOHIT,0);
		this.addTrait(Tohit);
		Attribute Armor=new Attribute(StabConstants.ARMOR,10);
		this.addTrait(Armor);
		Attribute Damage= new Attribute(StabConstants.DAMAGE,0);
		this.addTrait(Damage);
		Attribute Experience=new Attribute(StabConstants.EXPERIENCE,0);
		this.addTrait(Experience);
		Attribute Saving=new Attribute(StabConstants.SAVING,0);
		this.addTrait(Saving);
	    this.setMaxMovePoints(6);
	    this.setMaxActionPoints(1);
	}
	

}
