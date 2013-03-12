package com.stab.data.info.applicable;

import java.util.ArrayList;
import java.util.List;

import com.stab.data.animation.SwingAnimation;
import com.stab.model.info.BaseInfo;
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
	ArrayList<Damage> damage;
	ArrayList<Damage> critdamage;
	Attack attack;
	
	public AttackData(BaseInfo instigator,BaseInfo target) {
		super(instigator);
		//Valores por defecto de ejemplo
		animationType=SwingAnimation.ID;
		damage= new ArrayList<Damage>();
		critdamage= new ArrayList<Damage>();
		this.target=target;
		attack=createAttack();
	}

	public Attack createAttack(){
		return new Attack((BaseInfo)getInstigator());
	}
	
	@Override
	public void apply() {
			//Nada que hacer
	}
	
	@Override
	public BaseInfo getTarget() {
		return this.target;
	}
	
	public void setAttack(Attack attack) {
		this.attack = attack;
	}
	
	public Attack getAttack(){
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
	
	public void addDamage(Damage d){  //Es posible añadir daño de varios tipos (ej: slashing y fire) para una espada flaming
		damage.add(d);
		d.setInstigator(this.getInstigator());
	}
	
	
	public List<Damage> getDamage(boolean b) {
		ArrayList<Damage> list=new ArrayList<Damage>();
		list.addAll(getDamage());
		if (b){
			list.addAll(getCritDamage());
			return Damage.collapse(list);
		}
		return list;
	}
	
	public List<Damage> getDamage() {
		return Damage.collapse(damage);
	}
	public void addCritDamage(Damage d){  //Para añadir daño extra en critico (ej: flaming burst)
		critdamage.add(d);
		d.setInstigator(this.getInstigator());
	}
	
	public List<Damage> getCritDamage() {
		return Damage.collapse(critdamage);
	}
}
