package com.stab.data.info.applicable;

import java.util.ArrayList;
import java.util.List;

import com.stab.data.StabConstants;
import com.stab.data.animation.SwingAnimation;
import com.stab.data.info.equipment.Weapon;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.Modifier;


public class WeaponAttack extends Attack {

	Weapon weapon;
	String slot; 
	BaseInfo target;
	
	String animationType;
	String animationIcon;
	
	ArrayList<Applicable> onDamage;
	ArrayList<Applicable> onCrit;
	
	Attack attack;
	int baseDamage;
	int baseDamageType;
	int critRange;
	int critMultiplier;
	
	public WeaponAttack(BaseInfo instigator,Weapon weapon,BaseInfo target) {
		super(instigator);
		//Valores por defecto de ejemplo
		animationType=SwingAnimation.ID;
		onDamage= new ArrayList<Applicable>();
		onCrit= new ArrayList<Applicable>();
		baseDamage=0;
		baseDamageType=Damage.SLASHING_DAMAGE;
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
	
	public void setAnimationIcon(String animationIcon) {
		this.animationIcon = animationIcon;
	}
	public void setAnimationType(String animationType) {
		this.animationType = animationType;
	}
	
	public String getAnimationIcon() {
		return animationIcon;
	}
	public String getAnimationType() {
		return animationType;
	}
	
	public void addOnDamage(Applicable d){  //Es posible a�adir da�o de varios tipos (ej: slashing y fire) para una espada flaming
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
		list.addAll(getOnDamage());
		if (b){
			list.addAll(getOnCrit());
		}
		return collapse(list);
	}
	
	public List<Applicable> getOnDamage() {
		return collapse(onDamage);
	}
	public void addOnCrit(Damage d){  //Para a�adir da�o extra en critico (ej: flaming burst)
		onCrit.add(d);
		d.setInstigator(this.getInstigator());
	}
	
	public List<Applicable> getOnCrit() {
		return collapse(onCrit);
	}
	
	public void apply() {
		for (Applicable d:getEffects(isCritical())){
			getTarget().apply(d);
			if (d instanceof Damage)
				 System.out.println("Aplicando da�o: "+((Damage)d).getFinalAmount()+" de da�o (tipo "+((Damage)d).getType()+")");
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
	
	
	
	
}
