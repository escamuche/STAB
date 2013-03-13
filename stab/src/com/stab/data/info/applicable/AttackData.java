package com.stab.data.info.applicable;

import java.util.ArrayList;
import java.util.List;

import com.stab.data.animation.SwingAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.Damage;

/**
 * AttackData contiene los datos del ataque a lanzar.
 * Los distintos traits iran rellenandolos segun sea apropiado
 * Habra subclases para ranged attack, etc
 * 
 * Es perfectamente posible que el ataque sea cancelado por un trait (ej: estamos en presa, no podemos hacer un ranged attack, etc)
 * 
 * los traits pueden incluso añadir modificadores al ataque directamente (ej: racial enemy)
 * es posible tambien cambiar el tipo de ataque (pero delicado) ej: un arco con radiant ammo que use ranged touch en vez de ranged attack
 *
 */
public class AttackData extends Applicable {

	
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
	
	public AttackData(BaseInfo instigator,BaseInfo target) {
		super(instigator);
		//Valores por defecto de ejemplo
		animationType=SwingAnimation.ID;
		onDamage= new ArrayList<Applicable>();
		onCrit= new ArrayList<Applicable>();
		this.target=target;
		attack=createAttack();
		baseDamage=0;
		baseDamageType=Damage.SLASHING_DAMAGE;
		critRange=1;
		critMultiplier=2;
	}

	public Attack createAttack(){
		return new Attack((BaseInfo)getInstigator());
	}
	
	@Override
	public void apply() {
	}
	
	@Override
	public void validate() {
	}
	
	@Override
	public BaseInfo getTarget() {
		return this.target;
	}
	
	public void setAttack(Attack attack) {
		this.attack = attack;
	}
	
	public Attack getAttack(){
		attack.setInstigator(getInstigator());
		attack.setCritRange(critRange);
		attack.setAttackData(this);
		return attack;
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
	public void addOnCrit(Damage d){  //Para añadir daño extra en critico (ej: flaming burst)
		onCrit.add(d);
		d.setInstigator(this.getInstigator());
	}
	
	public List<Applicable> getOnCrit() {
		return collapse(onCrit);
	}
	
	
	public static List<Applicable> collapse(List<Applicable> data){
		ArrayList<Applicable> list=new ArrayList<Applicable>();
		ArrayList<Damage> damage=new ArrayList<Damage>();
		
		for (Applicable a:data){
			if (a instanceof Damage)
				damage.add((Damage)a);
			else
				list.add(a);
		}
		list.addAll(Damage.collapse(damage));
		return list;
	}
}
