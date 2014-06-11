package com.stab.data.actions.player.spells;

import java.util.EnumSet;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.data.info.equipment.SpellWeapon;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Spell implements SpellProperties {
	
	
	int level=0;
	String attribute;
	String casterClass;
	String save=null;
	
	int medium=SELECTED;
	
	int range=0;
	int cost=0;
	boolean affectedBySR=true;
	
	String weapon=null;
	boolean weaponChargeSpell=false;
	
	EnumSet<EffectDescriptor> descriptors;
	boolean verbal=true;
	boolean somatic=true;
	
	
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
	
	
	public int getRange(Info caster) {
		if (caster instanceof BaseInfo)
			return getRange((BaseInfo)caster);
		return 0;
	}
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
		
		if (weapon==null)
			switch(medium){
			case TOUCH: setWeapon(StabInit.getWeaponFactory().TOUCH);break;
			case RAY: setWeapon(StabInit.getWeaponFactory().RAY);break;
			case MISSILE: setWeapon(StabInit.getWeaponFactory().MISSILE);break;
			}
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
	
	public int getSPCost(int level){
		return (level*5)+5;
	}
	
	
	public SavingThrowEffect getSavingThrow(BaseInfo caster,BaseInfo target){
		if (this.getSave()!=null){
			SavingThrowEffect e= new SavingThrowEffect(caster,getSave(),target);
			int i=getDC(caster);
			e.setTargetNumber(i);
			return e;
		}
		return null;
	}
	
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	public SpellWeapon getWeapon() {
		if (weapon==null)
			return null;
		SpellWeapon w= new SpellWeapon(StabInit.getWeaponFactory().getWeapon(weapon));
		return w;
	}
	
	@Override
	public boolean isWeaponChargeSpell() {
		return weaponChargeSpell;
	}
	
	public void setWeaponChargeSpell(boolean weaponChargeSpell) {
		this.weaponChargeSpell = weaponChargeSpell;
	}
	
	@Override
	public EnumSet<EffectDescriptor> getDescriptors() {
		return descriptors;
	}
	
	public void setDescriptors(EffectDescriptor arg0){
		descriptors= EnumSet.of(arg0);
	}
	
	public void setDescriptors(EffectDescriptor arg0,EffectDescriptor...arg1){
		descriptors= EnumSet.of(arg0, arg1);
	}
	
	public void setSomatic(boolean somatic) {
		this.somatic = somatic;
	}
	
	public void setVerbal(boolean verbal) {
		this.verbal = verbal;
	}
	
	public boolean isSomatic() {
		return somatic;
	}
	
	public boolean isVerbal() {
		return verbal;
	}
	
	
	public boolean isSubjectToArcaneArmorFailure() {
		if (getCasterClass().equals(StabConstants.WIZARDCASTER))
			return true;
		if (getCasterClass().equals(StabConstants.SORCERERCASTER))
			return true;
		//TODO: mirar que hacer con el bardo
		return false;
	}
	
	public boolean isArcane(){
		if (getCasterClass().equals(StabConstants.WIZARDCASTER) ||
			getCasterClass().equals(StabConstants.SORCERERCASTER) ||
			getCasterClass().equals(StabConstants.BARDCASTER) 
				)
			return true;
		return false;
	}

	public boolean isDivine(){
		if (getCasterClass().equals(StabConstants.CLERICCASTER) ||
			getCasterClass().equals(StabConstants.DRUIDCASTER) ||
			getCasterClass().equals(StabConstants.PALADINCASTER) ||
			getCasterClass().equals(StabConstants.RANGERCASTER) 
				)
			return true;
		return false;
	}

	
}
