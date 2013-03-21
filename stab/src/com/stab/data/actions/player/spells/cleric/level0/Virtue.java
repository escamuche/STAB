package com.stab.data.actions.player.spells.cleric.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Heal;
import com.stab.model.info.trait.base.VisualEffect;

public class Virtue extends SpellOnTarget{
	
	public static final String ID="VIRTUE";

	@Override
	public boolean execute(Info yo, Info target) {
		
		
		BaseInfo t = (BaseInfo)target;
		t.setAttribute(StabConstants.MAXHP, +1);
		Heal heal = new Heal(1, t);
		t.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#Healing");
		sleep(500);
		t.apply(heal);
		//falta que no se puedan acumular los puntos de vida temporales...
		return true;
	}
	
	public Virtue() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
     setRange(2);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_druid_naturalperfection");
     setName("PurifyFood");
     this.setEffectType(HEAL);
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
	
}