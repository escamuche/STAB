package com.stab.pf.actions.player.spells;

import java.util.EnumSet;

import com.stab.data.info.other.ConcentrationActivity;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.NumericApplicable;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.info.applicable.SavingThrowEffect;
import com.stab.pf.info.equipment.SpellWeapon;

public class Spell implements SpellProperties {
	
	
	int level=0;
	String attribute;
	String casterClass;
	String save=null;
	
	int medium=SELECTED;
	int duration=INSTANT;
	int range=0;
	Integer cost=null;
	boolean affectedBySR=true;
	
	boolean spellLikeAbility=false;
	boolean isItem=false;
	
	String weapon=null;
	boolean weaponChargeSpell=false;
	
	EnumSet<EffectDescriptor> descriptors;
	boolean verbal=true;
	boolean somatic=true;
	
	Integer fixedCasterLevel=null;
	int casterLevelMod=0;
	
	
	float powerMult=1.0f;
	boolean maximized=false;
	boolean minimized=false;
	
	int castingTime=STANDARD;
	
	int concentration=NONE;
	
	String text;
	String description;
	String resource;
	boolean identified=false;
	boolean dismissable=false;
	int finalCasterLevel=0;
	SpellAction action;
	
	ConcentrationActivity concentrationActivity;
	
	public void setDescription(String description) {
		this.description = description;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDescription() {
		return description;
	}
	public String getText() {
		return text;
	}
	
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getResource() {
		return resource;
	}
	
	public void setAction(SpellAction action) {
		this.action = action;
	}
	public int getFinalCasterLevel() {
		return finalCasterLevel;
	}
	
	public SpellAction getAction() {
		return action;
	}
	public void setFinalCasterLevel(int finalCasterLevel) {
		this.finalCasterLevel = finalCasterLevel;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	
	
	public void setFixedCasterLevel(Integer fixedCasterLevel) {
		this.fixedCasterLevel = fixedCasterLevel;
	}
	
	public Integer getFixedCasterLevel() {
		return fixedCasterLevel;
	}
	
	private void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	@Override
	public String getAttribute() {
		return attribute;
	}
	
	public void setSpellLikeAbility(boolean spellLikeAbility) {
		this.spellLikeAbility = spellLikeAbility;
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
			setAttribute(StabConstants.INTELLIGENCE);
		if (casterClass.equals(StabConstants.CLERICCASTER)||casterClass.equals(StabConstants.DRUIDCASTER)||casterClass.equals(StabConstants.RANGERCASTER))
			setAttribute(StabConstants.WISDOM);
		if (casterClass.equals(StabConstants.BARDCASTER)||casterClass.equals(StabConstants.SORCERERCASTER)||casterClass.equals(StabConstants.PALADINCASTER))
			setAttribute(StabConstants.CHARISMA);
	}
	@Override
	public String getCasterClass() {
		return casterClass;
	}
	
	
	public int getMinimumCasterLevel(){
		return SpellUtils.getMinimumCasterLevel(getCasterClass(),getLevel());
	}
	
	public int getRange(Info caster) {
		if (caster instanceof BaseInfo)
			return getRange((BaseInfo)caster);
		return 0;
	}
	public int getRange(BaseInfo caster) {
		
		//TODO: comprobar metamagia que modificque el alcance
		
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
		int v;
		if (getFixedCasterLevel()!=null)
			v= getFixedCasterLevel();
		else
		 v= caster.getValue(getCasterClass());

		v=v+getCasterLevelMod();
		
		return v;
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
	
	public int getSPCost(){
		if(getLevel()==0)
			return 0;
		return (getLevel()*5)+5;
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
		if (isSpellLikeAbility() || isItem())
			return false;
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
	
	
	public boolean isSpellLikeAbility(){
		return spellLikeAbility;
	}

	
	public boolean provokesAoO(BaseInfo caster){
		if (isSpellLikeAbility())
			return false;
		//TODO: combat casting
		return true;
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

	
	public Spell getCopy(){
		Spell s=new Spell();
		copyProperties(s);
		/*try {
			BeanUtils.copyProperties(s, this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}/**/
		return s;
	}
	
	protected void copyProperties(Spell sp){
		sp.level=level;
		sp.attribute=attribute;
		sp.casterClass = casterClass;
		sp.save=save;
		sp.medium=medium;
		int medium=SELECTED;
		sp.range=range;
		if (cost!=null)
			sp.cost=new Integer(cost);
		sp.affectedBySR=affectedBySR;
		sp.spellLikeAbility=spellLikeAbility;
		sp.weapon=weapon;
		sp.weaponChargeSpell=weaponChargeSpell;
		sp.verbal=verbal;
		sp.somatic=somatic;
		if (descriptors!=null)
			sp.descriptors=descriptors.clone();
		if (fixedCasterLevel!=null)
			sp.fixedCasterLevel=new Integer(fixedCasterLevel);
		sp.casterLevelMod= casterLevelMod;
		sp.powerMult=powerMult;
		sp.maximized=maximized;
		sp.minimized=minimized;
		sp.isItem=isItem;
		sp.castingTime=castingTime;
		sp.duration=duration;
		sp.text=text;
		sp.description=description;
		sp.identified=identified;
		sp.dismissable=dismissable;
		sp.action=action;
		sp.resource=resource;
		sp.finalCasterLevel=finalCasterLevel;
		sp.concentration=concentration;
		sp.concentrationActivity=concentrationActivity;
	}
	
	public void setCasterLevelMod(int casterLevelMod) {
		this.casterLevelMod = casterLevelMod;
	}
	
	public int getCasterLevelMod() {
		return casterLevelMod;
	}
	
	
	public void setMaximized(boolean maximized) {
		this.maximized = maximized;
	}
	public boolean isMaximized() {
		return maximized;
	}
	
	public void setMinimized(boolean minimized) {
		this.minimized = minimized;
	}
	public boolean isMinimized() {
		return minimized;
	}
	
	public void setPowerMult(float powerMult) {
		this.powerMult = powerMult;
	}
	public float getPowerMult() {
		return powerMult;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getCost() {
		if (cost==null)
			return getSPCost();
		return cost;
	}
	
	public void setItem(boolean isItem) {
		this.isItem = isItem;
	}
	
	public boolean isItem() {
		return isItem;
	}
	
	
	public int getCastingTime() {
		return castingTime;
	}
	
	public void setCastingTime(int castingTime) {
		this.castingTime = castingTime;
	}
	
	//Aun no se usa, pero todo llegara.
	public void adjust(Applicable a){
		
		if (a instanceof RolledDamage){
			if (isMaximized()){
				((RolledDamage)a).setMax();
			}
			if (isMinimized())
				((RolledDamage)a).setMin();
		}
		
		if (a instanceof NumericApplicable){
			NumericApplicable n=(NumericApplicable)a;
			n.setAmount((int)(n.getAmount()*this.getPowerMult()));
		}
		
	}
	
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getDuration() {return duration;}
	
	public void setDismissable(boolean dismissable) {
		this.dismissable = dismissable;
	}
	public boolean isDismissable() {
		return dismissable;
	}
	
	public void setIdentified(boolean identified) {
		this.identified = identified;
	}
	public boolean isIdentified() {
		return identified;
	}
	
	public void setConcentration(int concentration) {
		this.concentration = concentration;
	}
	public int getConcentration() {
		return concentration;
	}
	
	public void setConcentrationActivity(
			ConcentrationActivity concentrationActivity) {
		this.concentrationActivity = concentrationActivity;
	}
	
	public ConcentrationActivity getConcentrationActivity() {
		return concentrationActivity;
	}
	
}
