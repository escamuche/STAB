package com.stab.data.animation;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.common.states.ValueState;
import com.tien.princess.engine.sprite.common.updaters.angle.AngleToRotation;
import com.tien.princess.engine.sprite.common.updaters.angle.MoveA;
import com.tien.princess.engine.sprite.common.updaters.conditions.OnRefDestroyed;
import com.tien.princess.engine.sprite.common.updaters.ref.StickToRef;
import com.tien.princess.engine.utils.PaintUtils;

public class TinkerAnimation extends Animation {
	
	public static final String ID=VisualEffect.TINKER_ANIMATION;
	
	public TinkerAnimation() {
		
		setTime(10);
	}
	
	@Override
	public void start() {
		super.start();
	
		
		ValueState st= new ValueState();
		
		st.addUpdater(new OnRefDestroyed());
		st.addUpdater(new StickToRef(true));
		st.addUpdater(new MoveA());
		st.addUpdater(new AngleToRotation());
	
	
		
		
		Painter p=PaintUtils.getPainter("effects/gear");
	
		
		StabSprite icon=new StabSprite();
		icon.setA(0);
		icon.setSa(0.03f);
	
		icon.setPos(getOriginPoint());
		icon.setSize(64,64);
		
		icon.setPainter(p);
		
		icon.setState(st);
		icon.setRef(AnimUtils.getSprite(getSource()));
		
		StateSprite s=AnimUtils.getSprite(getSource());
		((AbstractGameScreen)s.getScreen()).add(icon);
	}

}

