package com.stab.data.actions.player.spells;

import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;

public abstract class SpellOnSelf extends SelfAction  implements Spell {

	int level=0;
	String attribute;
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	@Override
	public String getAttribute() {
		return attribute;
	}
	
	@Override
	public int getDC(BaseInfo caster) {
		int i=10+getLevel();
		i=i+(caster.getValue(getAttribute())-10)/2;
		//Calcular bonos por escuela en base a feats
		return i;
	}
	
	@Override
	public boolean validateActor(BaseInfo i) {
		if (i.getValue(getAttribute())<10+getLevel())
			return false;
		return super.validateActor(i);
	}
	
}
