package com.stab.pf.info.equipment;

import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.trait.base.gear.Ammo;

public class BasicAmmo extends Ammo {

	
	Integer dice; 
	Integer dices;
	Integer baseDamageType;
	Integer critRange;
	Integer critMultiplier;
	String animationIcon;
	
	
	public BasicAmmo(String name,Integer dices, Integer dice, Integer baseDamageType, Integer critRange,
			Integer critMultiplier,String animationIcon) {
		super();
		this.setName(name);
		this.dice = dice;
		this.dices = dices;
		this.baseDamageType = baseDamageType;
		this.critRange = critRange;
		this.critMultiplier = critMultiplier;
		this.animationIcon = animationIcon;
		this.setSlots(HumanoidGear.AMMO);
	}
	
	@Override
	public void affect(WeaponAttack app) {
		super.affect(app);
		if (baseDamageType!=null)
			app.setBaseDamageType(baseDamageType);
		if (critMultiplier!=null)
			app.setCritMultiplier(critMultiplier);
		if (critRange!=null)
			app.setCritRange(critRange);
		if (animationIcon!=null)
			app.setAnimationIcon(animationIcon);
		
		
		//forzar calcular el daño. Revisar que sea correcto!
		if (dice!=null){
			RolledDamage d=new RolledDamage(this.dices, dice, 0, baseDamageType, app.getInstigator());
			app.setBaseDamageApplicable(d);
		}
	}
	
	@Override
	public boolean canAffect(Applicable a) {
		return super.canAffect(a);
	}
	
}
