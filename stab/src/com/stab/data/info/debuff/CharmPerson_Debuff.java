package com.stab.data.info.debuff;

import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.monster.MonstrousHumanoid;
import com.stab.data.info.monster.monstertraits.HumanoidTraits;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Debuff;

public class CharmPerson_Debuff extends Debuff {
	
	public static final String ID="CHARMPERSON_DEBUFF";
	BaseInfo target = new BaseInfo();
	
	public CharmPerson_Debuff(BaseInfo atacado) {
	
		target=atacado;
		this.setAnimIcon("actions/charmperson");				
		this.setSound("HolyCast");
		this.setResource("actions/charmperson");                  
		this.setName("Charm Person");
		
		atacado.playAnimationOn(ShootProyectileAnimation.ID, atacado.getToken(), "PARTICLE#magicmissile");
		
		if(atacado.hasTrait(HumanoidTraits.ID) || atacado.hasTrait(MonstrousHumanoid.ID))
			atacado.setFaction(0);
		
	}
	
	@Override
	public void end() {
		target.setFaction(1);
		super.end();
	}
}
