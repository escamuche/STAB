package com.stab.data.animation;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.data.animation.state.LootState;
import com.stab.model.animation.Animation;
import com.stab.model.basic.Sprite;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;

public class LootDropAnimation extends Animation{

	public static final String ID=VisualEffect.LOOT_DROP_ANIMATION;
	
	public LootDropAnimation() {
		setBlocking(true);
		setTime(700);
	}
	
	@Override
	public void start() {
		super.start();
		StateSprite s=AnimUtils.getSprite(getSource());
	//	((Sprite)getSource()).playSound("flippy");
		LootState st=new LootState();
		s.setState(st);
	}
	
	
}


