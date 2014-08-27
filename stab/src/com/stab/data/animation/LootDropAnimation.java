package com.stab.data.animation;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.common.Constants;
import com.stab.data.animation.state.LootState;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.utils.PaintUtils;

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
	//	sp.setDesiredLayer(Constants.EFFECTS);
	//	sp.setPainter(s.getPainter());

		LootState st=new LootState();
	
		st.setTimed(7000, StateSet.DESTROYED);
		sp.setState(st);
		sp.setPos(getOriginPoint());
		sp.setSize(64,64);
		
		BasicAnimState a= new BasicAnimState(6000);
		Painter p=PaintUtils.getPainter("tokens/genericDrop");
		sp.setPainter(p);
		sp.setState(a);
		((AbstractGameScreen)s.getScreen()).add(sp);
	}
	
	
}


