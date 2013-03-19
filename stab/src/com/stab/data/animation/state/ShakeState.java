package com.stab.data.animation.state;



import com.stab.client.slick.base.updaters.SyncState;
import com.stab.common.value.SineValueProvider;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.State;

public class ShakeState extends State {

  
	
	public ShakeState(long time) {
		super.setTimed((int)time, SyncState.ID);
	}
	
	
	@Override
	public void enter(Sprite sprite) {
		super.enter(sprite);
		SineValueProvider val3= new SineValueProvider();
		val3.setScale(10);
		//val3.setFactor(100);
		val3.setMax(this.getTimed());
		((ValuePainter)sprite.getPainter()).setDx(val3);
	}
	

	
	@Override
	public void leave(Sprite sprite) {
		super.leave(sprite);
		((ValuePainter)sprite.getPainter()).setDx(0f);
	}
	
}
