package com.stab.pf.info.debuff;

import com.stab.common.Constants;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.base.DamageModification;
import com.stab.model.info.trait.base.DebuffEffect;
import com.stab.pf.StabConstants;
import com.stab.pf.info.applicable.PathfinderAttack;

public class SmiteEvil_Debuff extends DebuffEffect implements Attends<PathfinderAttack> {


	BaseInfo paladin = null;
	
	public void setPaladin(BaseInfo paladin) {
		this.paladin = paladin;
	}
	
	@Override
	public void attend(PathfinderAttack arg0) {
		
		if(arg0.getInstigator() == paladin){
			int daño = paladin.getValue(StabConstants.PALADINCASTER);
			int dar = paladin.getAttributeValue(StabConstants.CHARISMA);
			DamageModification d = new DamageModification(Damage.HOLY_DAMAGE, daño);
			
			arg0.addModifier(dar);
			
		}
		
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		if(arg0 instanceof PathfinderAttack)				
			return true;
		return false;
	}

	
	@Override
	protected Sprite createEffectSprite() {
		DecorToken t=createEffectToken(null,Constants.AURAS);
		t.setResource("PARTICLE#effects/yellowAuraSmall");
		return t;
	}
	
}
