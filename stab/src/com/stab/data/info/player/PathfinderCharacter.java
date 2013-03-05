package com.stab.data.info.player;



import com.stab.data.info.BasicAttributes;
import com.stab.model.info.base.Character;

public class PathfinderCharacter extends Character {
	
public static final String ID="PATH_INFO";
	
	
	@Override
	public void init() {
		super.init();
		this.addTrait(new BasicAttributes());
		this.setMaxMovePoints(6);
	    this.setMaxActionPoints(1);
	}
}
		
		/*Attribute tohit=new Attribute(StabConstants.TOHIT,0);
		this.addTrait(tohit);
		Attribute armor=new Attribute(StabConstants.ARMOR,10);
		this.addTrait(armor);
		Attribute damage= new Attribute(StabConstants.DAMAGE,0);
		this.addTrait(damage);
		Attribute experience=new Attribute(StabConstants.EXPERIENCE,0);
		this.addTrait(experience);
		Attribute saving=new Attribute(StabConstants.SAVING,0);
		this.addTrait(saving);
		Attribute tohitranged=new Attribute(StabConstants.TOHITRANGED,0);
		this.addTrait(tohitranged);
		Attribute damageranged=new Attribute(StabConstants.DAMAGERANGED,0);
		this.addTrait(damageranged);
	    this.setMaxMovePoints(6);
	    this.setMaxActionPoints(1);
	    Attribute strenght=new Attribute(StabConstants.STRENGHT,0);
		this.addTrait(strenght);*/
