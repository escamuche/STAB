package com.stab.data.info.debuff;

import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.monster.MonstrousHumanoid;
import com.stab.data.info.monster.monstertraits.HumanoidTraits;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.DebuffEffect;

public class CharmPerson_Debuff extends DebuffEffect {
	
	public static final String ID="CHARMPERSON_DEBUFF";
	BaseInfo target = getTarget();
	
	public CharmPerson_Debuff() {
	
		this.setAnimIcon("actions/charmperson");				
		this.setSound("HolyCast");
		this.setResource("actions/charmperson");                  
		this.setName("Charm Person");
		
		target.playAnimationOn(ShootProyectileAnimation.ID, target.getToken(), "PARTICLE#magicmissile");
		
		if(target.hasTrait(HumanoidTraits.ID) || target.hasTrait(MonstrousHumanoid.ID))
			target.setFaction(0);
		
	}
	
	@Override
	public void end() {
		target.setFaction(1);
		super.end();
	}
}
