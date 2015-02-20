package com.stab.pf.actions.player.spells.lvl1.effects;

import com.stab.common.Constants;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.VisualEffect;

public class SummonedCreature extends VisualEffect {

	
	public SummonedCreature() {
		setTime(1);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		baseInfo.playSound("effects/SpiritWolf");
		baseInfo.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#spells/summoned");
		baseInfo.playAnimation(VisualEffect.DECAY_ANIMATION);
		baseInfo.setScene(null);
		baseInfo.destroy();
	}
	
	@Override
	protected Sprite createEffectSprite() {
		DecorToken t=createEffectToken("summoned",Constants.EFFECTS);
		return t;
	}
	
}
