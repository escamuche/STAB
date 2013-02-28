package com.stab.data.animation.state;

import com.stab.common.value.Simple2PointValueProvider;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;

public class TestAnimState extends BasicAnimState{

	public TestAnimState(long t) {
		super(t);
	}
	
	@Override
	public void enter(Sprite sprite) {
		super.enter(sprite);
		Simple2PointValueProvider val= new Simple2PointValueProvider(0.1f, 0f);
		val.setMax(this.getTimed());
		((ValuePainter)sprite.getPainter()).setBrightness(val);
	}
	
	
	@Override
	public void leave(Sprite sprite) {
		super.leave(sprite);
		((ValuePainter)sprite.getPainter()).setBrightness(1.0f);
	}
}
