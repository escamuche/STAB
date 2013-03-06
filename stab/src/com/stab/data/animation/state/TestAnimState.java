package com.stab.data.animation.state;

import com.stab.common.value.Simple2PointValueProvider;
import com.stab.common.value.SineValueProvider;
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
		
	//	((ValuePainter)sprite.getPainter()).setLog(true);
	/*	
		Simple2PointValueProvider val= new Simple2PointValueProvider();
		//val.setScale(-1);
		val.setMax(this.getTimed());
		((ValuePainter)sprite.getPainter()).setBrightness(val);
	/*	
		Simple2PointValueProvider val2= new Simple2PointValueProvider(0.2f, 1f);
		val2.setMax(this.getTimed());
		((ValuePainter)sprite.getPainter()).setScaleX(val2);
		((ValuePainter)sprite.getPainter()).setScaleY(val2);
	/*
		//Simple2PointValueProvider val3= new Simple2PointValueProvider(0f, 1f);
		SineValueProvider val3= new SineValueProvider();
		val3.setScale(10);
		val3.setFactor(1000);
		val3.setMax(this.getTimed());
		((ValuePainter)sprite.getPainter()).setDx(val3);
		//((ValuePainter)sprite.getPainter()).setDy(val3);
		/**/
/*		
		Simple2PointValueProvider val2= new Simple2PointValueProvider(0f, 1f);
	//	val2.setScale((float)Math.PI*2);
		val2.setScale(360);
		val2.setMax(this.getTimed());
		((ValuePainter)sprite.getPainter()).setRotation(val2);
	/**/
	}
	
	
	@Override
	public void leave(Sprite sprite) {
		super.leave(sprite);
		((ValuePainter)sprite.getPainter()).setBrightness(1.0f);
		((ValuePainter)sprite.getPainter()).setScaleX(1.0f);
		((ValuePainter)sprite.getPainter()).setScaleY(1.0f);
	}
}
