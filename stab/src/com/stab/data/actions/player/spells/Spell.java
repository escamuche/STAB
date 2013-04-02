package com.stab.data.actions.player.spells;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;

public class Spell implements SpellProperties {
	
	
	int level=0;
	String attribute;
	String casterClass;
	String save=null;
	
	int medium=TARGET;
	
	int range=0;
	boolean affectedBySR=false;
	
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
		return i;
	}
	
	
	public void setCasterClass(String casterClass) {
		this.casterClass = casterClass;
		if (casterClass.equals(StabConstants.WIZARDCASTER))
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
	
	
	@Override
	public int getRange(BaseInfo caster) {
		switch(range){
			case SELF: return 0;
			case TOUCH: return 1; //Sumar reach en un futuro!
			case CLOSE: return 5+(getCasterLevel(caster)/2);
			case MEDIUM: return 20+(getCasterLevel(caster)*2);
			case LONG: return 80+(getCasterLevel(caster)*8);
			case ANYWHERE: return Integer.MAX_VALUE;
		}
		if (range>=FIXED)
			return range-FIXED;
		return 0; 
	}
	
	public void setRange(int range) {
		this.range = range;
		if (range==TOUCH)
			if (medium!=TOUCH)
				medium=TOUCH;
		if (range==SELF)
			if (medium!=SELF)
				medium=SELF;
	}
	
	
	@Override
	public int getCasterLevel(BaseInfo caster) {
	//	System.out.println("Caster level is "+caster.getAttributeValue(getCasterClass())+" in  "+getCasterClass());
		return caster.getValue(getCasterClass());
	}

	@Override
	public String getSave() {
		return save;
	}
	
	public void setSave(String save) {
		this.save = save;
	}
	
	
	@Override
	public int getMedium() {
		return medium;
	}
	
	

	
	public void setMedium(int medium) {
		this.medium = medium;
	
		if (medium==TOUCH)
			if (range!=TOUCH)
				range=TOUCH;
		if (medium==SELF)
			if (range!=SELF)
				range=SELF;
	}
	
	
	@Override
	public boolean canCast(BaseInfo caster) {
		if (getAttribute()!=null)
			if (caster.getValue(getAttribute())-10<getLevel())
				return false;
		//TODO: el level vs el caster level
		return true;
	}
	
	public void setAffectedBySR(boolean affectedBySR) {
		this.affectedBySR = affectedBySR;
	}
	public boolean isAffectedBySR() {
		return affectedBySR;
	}
	
	

	
	
	
	public SavingThrowEffect getSavingThrow(BaseInfo caster){
		if (this.getSave()!=null){
			SavingThrowEffect e= new SavingThrowEffect(caster,getSave(),getDC(caster));
			return e;
		}
		return null;
	}
	
	
}
