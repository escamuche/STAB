package com.stab.data.info.debuff.condition;

import com.stab.common.Constants;
import com.stab.data.animation.GenericSpriteOnAnimation;
import com.stab.data.animation.sprite.SpecialEffectsSpriteFactory;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.BaseInfo;

public class DazedCondition extends UnableToActCondition{

	public static final String ID="DAZEDCONDITION_DEBUFF";
	
	 
	
	public DazedCondition() {
		
	}
	
	@Override
	public void turnStarts() {
		BaseInfo i = getTarget();
		i.setTurnDone(true);
		super.turnStarts();
	}
	
	@Override
	protected DecorToken createEffectToken() {
		DecorToken t=createEffectToken(null,Constants.EFFECTS);
		return t;
	}
	
	protected void configureEffectToken(DecorToken token) {
		token.playAnimation(GenericSpriteOnAnimation.ID,SpecialEffectsSpriteFactory.DAZED);
	}
	
}
