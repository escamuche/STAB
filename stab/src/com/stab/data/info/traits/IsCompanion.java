package com.stab.data.info.traits;

import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.TargetedTrait;

public class IsCompanion extends TargetedTrait {

	
	Creature owner;
	
	
	public void setOwner(Creature owner) {
		this.owner = owner;
	}
	
	public Creature getOwner() {
		return owner;
	}
	
	
	public HasCompanion getOwnerTrait(){
		if (getOwner()==null)
			return null;
		//TODO: multiple animal companions?
		//return getOwner().getTrait(HasCompanion)
		return null;
	}
	
}
