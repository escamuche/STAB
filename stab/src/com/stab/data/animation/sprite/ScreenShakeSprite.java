package com.stab.data.animation.sprite;

import java.awt.Point;

import com.stab.common.Constants;
import com.stab.common.value.SineValueProvider;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.base.TagPoint;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.states.ValueState;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;

public class ScreenShakeSprite extends StateSprite {

	Point old;
	
	public ScreenShakeSprite(long l, int amount, boolean vertical) {
		ValueState st= new ValueState();
		st.setTimed(l, StateSet.DESTROYED);
		SineValueProvider val3= new SineValueProvider();
		val3.setScale(amount);
		st.setRadius(val3);
		this.setA(0);
		if (vertical)
			this.setA(Constants.ANGLE_90);
		st.addUpdater(new Orbit());
		
		old=new Point(getScreen().getViewBounds().x,getScreen().getViewBounds().y);
		this.setPos(old);
		
		TagPoint p= new TagPoint();
		p.setPos(getPos());
		setRef(p);
		
		this.setState(st);
	}
	
	@Override
	public void destroy() {
		getScreen().setViewPoint(old.x, old.y);
		super.destroy();
	}
}
