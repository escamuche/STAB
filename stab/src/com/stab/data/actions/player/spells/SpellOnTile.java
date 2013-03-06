package com.stab.data.actions.player.spells;

import com.stab.data.StabConstants;
import com.stab.model.action.TileAction;
import com.stab.model.info.BaseInfo;

public abstract class SpellOnTile extends TileAction  implements Spell {

	int level=0;
	String attribute;
	String casterClass;
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	
	
	private void setAttribute(String attribute) {
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
	public void setCasterClass(String casterClass) {
		this.casterClass = casterClass;
		if (casterClass.equals(casterClass.equals(StabConstants.WIZARDCASTER)))
			setAttribute(StabConstants.INTELIGENCE);
		if (casterClass.equals(StabConstants.CLERICCASTER)||casterClass.equals(StabConstants.DRUIDCASTER)||casterClass.equals(StabConstants.RANGERCASTER))
			setAttribute(StabConstants.WISDOM);
		if (casterClass.equals(StabConstants.BARDCASTER)||casterClass.equals(StabConstants.SORCERERCASTER)||casterClass.equals(StabConstants.PALADINCASTER))
			setAttribute(StabConstants.CHARISMA);
	}
	@Override
	public String getCasterClass() {
		return casterClass;
	}
	
	
}
