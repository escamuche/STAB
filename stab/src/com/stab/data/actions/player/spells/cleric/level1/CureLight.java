package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Heal;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.util.Roll;

public class CureLight extends SpellOnTarget{
	
	public static final String ID="CURELIGHT_CLERIC";


	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacado = (BaseInfo)target;
		int dañobase=Roll.d8()+1;
		Heal heal = new Heal(dañobase, Atacado);
		Atacado.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#Healing");
		sleep(500);
		Atacado.apply(heal);
		return true;
		}
	
	public CureLight() {
     setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/curelightwounds");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("CureLight");
     this.setEffectType(HEAL);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
	

}