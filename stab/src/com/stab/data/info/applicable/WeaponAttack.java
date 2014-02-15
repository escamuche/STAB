package com.stab.data.info.applicable;

import java.util.ArrayList;
import java.util.List;

import com.stab.data.animation.SwingAnimation;
import com.stab.data.info.equipment.SpellActionEffect;
import com.stab.data.info.equipment.Weapon;
import com.stab.model.basic.scenes.MapLogic;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.Damage;


public class WeaponAttack extends Attack {

	Weapon weapon;
	String slot; 
	BaseInfo target;
	
	String animationType;
	String missAnimationType;
	String animationIcon;
	
	ArrayList<Applicable> onDamage;
	ArrayList<Applicable> onCrit;
	
	Attack attack;
	int baseDamage;
	int baseDamageType;
	int critRange;
	int critMultiplier;
	Damage baseDamageApplicable;
	
	public WeaponAttack(BaseInfo instigator,Weapon weapon,BaseInfo target) {
		super(instigator,target);
		//Valores por defecto de ejemplo
		animationType=SwingAnimation.ID;
		missAnimationType=null;
		onDamage= new ArrayList<Applicable>();
		onCrit= new ArrayList<Applicable>();
		baseDamage=0;
		baseDamageType=Damage.NO_DAMAGE;
		baseDamageApplicable=null;
		setCritRange(1);
		setCritRange(2);
		this.setTarget(target);
		setWeapon(weapon);
	}
	
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getSlot() {
		return slot;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		if (weapon!=null){
			
			
		}
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void setBaseDamageApplicable(Damage baseDamageApplicable) {
		this.baseDamageApplicable = baseDamageApplicable;
	}
	public Damage getBaseDamageApplicable() {
		return baseDamageApplicable;
	}
	
	public void setAnimationIcon(String animationIcon) {
		this.animationIcon = animationIcon;
	}
	public void setAnimationType(String animationType) {
		this.animationType = animationType;
	}
	public void setMissAnimationType(String animationType) {
		this.missAnimationType = animationType;
	}
	
	public String getMissAnimationType() {
		if (missAnimationType!=null)
			return missAnimationType;
		return animationType;
	}
	public String getAnimationIcon() {
		return animationIcon;
	}
	public String getAnimationType() {
		return animationType;
	}
	
	public void addOnDamage(Applicable d){  //Es posible añadir daño de varios tipos (ej: slashing y fire) para una espada flaming
		onDamage.add(d);
		d.setInstigator(this.getInstigator());
	}
	
	
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	public void setBaseDamageType(int baseDamageType) {
		this.baseDamageType = baseDamageType;
	}
	public int getBaseDamageType() {
		return baseDamageType;
	}
	public int getBaseDamage() {
		return baseDamage;
	}
	
	public void modifyBaseDamage(int amount){
		baseDamage=baseDamage+amount;
	}
	
	public void setCritMultiplier(int critMultiplier) {
		this.critMultiplier = critMultiplier;
	}
	public void setCritRange(int critRange) {
		this.critRange = critRange;
	}
	public int getCritMultiplier() {
		return critMultiplier;
	}
	public int getCritRange() {
		return critRange;
	}
	
	
	
	
	public Damage createDamage(boolean crit){
		int num=getBaseDamage();
		if (crit)
			num=num*getCritMultiplier();
		Damage d=new Damage(num,getBaseDamageType(),getInstigator());
		if (crit)
			d.setCritical(true);
		return d;
	}
	
	public List<Applicable> getEffects(boolean b) {
		ArrayList<Applicable> list=new ArrayList<Applicable>();
		if (getBaseDamage()>0)
			list.add(createDamage(b));
		if (this.getBaseDamageApplicable()!=null){
			RolledDamage d=(RolledDamage)getBaseDamageApplicable();
		//	System.out.println("Base dice damage: "+d.dice+" "+d.numberOfDice+" "+d.bonus+d.getFinalAmount());
			list.add(d);
		}
		list.addAll(getOnDamage());
		if (b){
			list.addAll(getOnCrit());
			if (this.getBaseDamageApplicable()!=null)
			for (int f=1;f<getCritMultiplier();f++){
				Damage dc;
				try {
					dc = (Damage)getBaseDamageApplicable().clone();
					dc.setCritical(true);
					list.add(dc);
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			
			}
		}
		return collapse(list);
	}
	
	public List<Applicable> getOnDamage() {
		return collapse(onDamage);
	}
	public void addOnCrit(Applicable d){  //Para añadir daño extra en critico (ej: flaming burst)
		onCrit.add(d);
		d.setInstigator(this.getInstigator());
	}
	
	public List<Applicable> getOnCrit() {
		return collapse(onCrit);
	}
	
	public void applyEffects() {
		for (Applicable d:getEffects(isCritical())){
			if (d instanceof SpellActionEffect)
				((SpellActionEffect)d).setCritical(isCritical());
			getTarget().apply(d);
			if (d instanceof Damage)
				 System.out.println("Aplicando daño: "+((Damage)d).getFinalAmount()+" de daño (tipo "+((Damage)d).getType()+")");
			else
				System.out.println("Aplicando "+d.getClass().getSimpleName());
		}
		
	}
	
	@Override
	public void validate() {
		super.validate();
		if (getWeapon()!=null){
			getWeapon().attackDone(this);
			System.out.println("Ataque: "+this.getClass().getSimpleName()+" con "+getWeapon().getName()+"  roll "+getRollResult()+" + "+getFinalModifier()+"   against "+getFinalTargetNumber()+"  result: "+getResult()+" (hits:"+hits()+" critical: "+isCritical()+" botch: "+isBotch()+")");
		}else{
			System.out.println("Ataque: "+this.getClass().getSimpleName()+" sin arma? roll "+getRollResult()+" + "+getFinalModifier()+"   against "+getFinalTargetNumber()+"  result: "+getResult()+" (hits:"+hits()+" critical: "+isCritical()+" botch: "+isBotch()+")");
		}
	}
	
	
	public float getDistance(){
		MapLogic ml=getTarget().getMapLogic();
		return ml.getDistance(getInstigator(), getTarget());
	}
	
}
