package com.stab.data.info.debuff;

import com.stab.common.Constants;
import com.stab.data.StabConstants;
import com.stab.data.info.applicable.Attack;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.base.DamageModification;
import com.stab.model.info.trait.base.Debuff;

public class SmiteEvil_Debuff extends Debuff implements Attends<Attack> {


	BaseInfo paladin = null;
	
	public void setPaladin(BaseInfo paladin) {
		this.paladin = paladin;
	}
	
	@Override
	public void attend(Attack arg0) {
		
		if(arg0.getInstigator() == paladin){
			int daño = paladin.getValue(StabConstants.PALADINCASTER);
			int dar = paladin.getAttributeValue(StabConstants.CHARISMA);
			DamageModification d = new DamageModification(Damage.HOLY_DAMAGE, daño);
			
			arg0.addModifier(dar);
			
		}
		
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		if(arg0 instanceof Attack)				
			return true;
		return false;
	}

	
	@Override
	protected DecorToken createEffectToken() {
		DecorToken t=createEffectToken(null,Constants.AURAS);
		t.setResource("PARTICLE#generic/yellowAuraSmall");
		return t;
	}
	
}
