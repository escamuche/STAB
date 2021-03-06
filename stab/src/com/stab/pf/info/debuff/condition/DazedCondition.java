package com.stab.pf.info.debuff.condition;

import java.awt.Color;

import com.stab.client.animation.GenericSpriteOnAnimation;
import com.stab.common.Constants;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.BaseInfo;
import com.stab.pf.animations.sprite.SpecialEffectsSpriteFactory;

public class DazedCondition extends UnableToActCondition{

	public static final String ID="DAZEDCONDITION_DEBUFF";
	
	 
	
	public DazedCondition() {
		
	}
	
	@Override
	public void turnStarts() {
		BaseInfo i = getTarget();
		i.setTurnDone(true);
		i.showFloatingText("DAZED", Color.yellow);
		super.turnStarts();
	}
	
	@Override
	protected Sprite createEffectSprite() {
		DecorToken t=createEffectToken(null,Constants.EFFECTS);
		return t;
	}
	
	protected void configureEffectToken(DecorToken token) {
		token.playAnimation(GenericSpriteOnAnimation.ID,SpecialEffectsSpriteFactory.DAZED);
	}
	
}
