package com.stab.data.info.equipment;

import com.stab.data.info.applicable.WeaponAttack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;

public abstract class Weapon extends Item implements Affects<WeaponAttack>{

	protected String animationIcon;
	protected String animationType;
	protected String missAnimationType=null;

	@Override
	public boolean canAffect(Applicable a) {
		if (a instanceof WeaponAttack)
			return ((WeaponAttack)a).getWeapon()==this;
		return false;
	}

	@Override
	public void affect(WeaponAttack app) {
		app.setAnimationIcon(animationIcon);
		app.setAnimationType(animationType);
		app.setMissAnimationType(missAnimationType);
	}

	public void attackDone(WeaponAttack attack){
		//Nada a priori. las subclases pueden comprobar cosas, pasarselo a sus traits, etc
	}

	public void setAnimationIcon(String animationIcon) {
		this.animationIcon = animationIcon;
	}

	public String getAnimationIcon() {
		return animationIcon;
	}

	public void setAnimationType(String animationType) {
		this.animationType = animationType;
	}

	public String getAnimationType() {
		return animationType;
	}
	
	public void setMissAnimationType(String missAnimationType) {
		this.missAnimationType = missAnimationType;
	}
	public String getMissAnimationType() {
		return missAnimationType;
	}
	
	
	public int getEffectValue(BaseInfo i, Info target){
		return 1;
	}
}
