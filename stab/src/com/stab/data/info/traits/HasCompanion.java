package com.stab.data.info.traits;

import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.TargetedTrait;

public class HasCompanion extends TargetedTrait {
	
	
	Creature companion;
	
	
	public void setCompanion(Creature companion) {
		this.companion = companion;
		IsCompanion cmp=new IsCompanion();
		cmp.setOwner((Creature)this.getTarget());
		companion.addTrait(cmp);
	}
	public Creature getCompanion() {
		return companion;
	}

	
	public boolean isSummoned(){
		if (getCompanion()==null)
			return false;
		return getCompanion().getScene()==getTarget().getScene();
	}
	
	public boolean canSummon(){
		if (getCompanion()==null)
			return false;
		if (isSummoned())
			return false;
		if (getCompanion().isDestroyed())
			return false;
		return true;
	}
	
	
}
