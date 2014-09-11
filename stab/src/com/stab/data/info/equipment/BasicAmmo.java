package com.stab.data.info.equipment;

import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.trait.base.gear.Ammo;

public class BasicAmmo extends Ammo {

	
	int dice; 
	int dices;
	int baseDamageType;
	int critRange;
	int critMultiplier;
	String animationIcon;
	
	
	public BasicAmmo(String name,int dices, int dice, int baseDamageType, int critRange,
			int critMultiplier,String animationIcon) {
		super();
		this.setName(name);
		this.dice = dice;
		this.dices = dices;
		this.baseDamageType = baseDamageType;
		this.critRange = critRange;
		this.critMultiplier = critMultiplier;
		this.animationIcon = animationIcon;
	}
	
	@Override
	public void affect(WeaponAttack app) {
		super.affect(app);
		app.setBaseDamageType(baseDamageType);
		app.setCritMultiplier(critMultiplier);
		app.setCritRange(critRange);
		if (animationIcon!=null)
			app.setAnimationIcon(animationIcon);
		
		
		//forzar calcular el daño. Revisar que sea correcto!
		RolledDamage d=new RolledDamage(this.dices, dice, 0, baseDamageType, app.getInstigator());
		app.setBaseDamageApplicable(d);
	}
	
}
