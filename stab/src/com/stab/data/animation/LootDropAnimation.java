package com.stab.data.animation;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.common.Constants;
import com.stab.data.animation.state.LootState;
import com.stab.model.animation.Animation;
import com.stab.model.basic.Sprite;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.states.StateSet;

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
		StabSprite sp=new StabSprite();
		sp.setDesiredLayer(Constants.OVERMAP);
		sp.setPainter(s.getPainter());
		//sp.setRef(s);
	//	((Sprite)getSource()).playSound("flippy");
		LootState st=new LootState();
		st.setTimed(700, StateSet.DESTROYED);
		sp.setState(st);
		sp.setPos(getOriginPoint());
		sp.setSize(64,64);
		
	
		((AbstractGameScreen)s.getScreen()).add(sp);
	}
	
	
}


