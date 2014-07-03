package com.stab.data.actions.general;

import com.stab.annotations.Instanced;
import com.stab.data.animation.GenericProyectileAnimation;
import com.stab.data.animation.GenericProyectileMissAnimation;
import com.stab.model.action.Action;
import com.stab.model.basic.token.Token;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.trait.base.gear.Weapon;

@Instanced 
public abstract class WeaponAttackAction extends Action {

	public static final String ID="WEAPON_ATTACK_ACTION";
	
	Weapon weapon;
	
	public WeaponAttackAction() {
		super();
	}

	protected void playHitAnimation(WeaponAttack ad, BaseInfo origin, Token target) {
	
		if (GenericProyectileAnimation.ID.equals(ad.getAnimationType())){
			sleep(origin.playAnimationOn(GenericProyectileAnimation.ID,target.getPos(),ad.getAnimationIcon(),origin.getWidth()));
			return;
		}
		sleep(origin.playAnimationOn(ad.getAnimationType(),target,ad.getAnimationIcon()));
	}

	protected void playMissAnimation(WeaponAttack ad, BaseInfo origin, Token target) {
	
		if (GenericProyectileAnimation.ID.equals(ad.getAnimationType())){
			sleep(origin.playAnimationOn(GenericProyectileMissAnimation.ID,target.getPos(),ad.getAnimationIcon(),origin.getWidth()));
			return;
		}
		sleep(origin.playAnimationOn(ad.getMissAnimationType(),target,ad.getAnimationIcon()));
	}

	public Weapon getWeapon(BaseInfo i) {
		return weapon;
	}

	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	@Override
	public String getResource(BaseInfo info) {
		Weapon arma=null;
		arma=getWeapon(info);
		if (arma==null){
		//	System.out.println("No hay arma! resource para "+info);
			return super.getResource(info);
		}
		return arma.getResource();
	}

}