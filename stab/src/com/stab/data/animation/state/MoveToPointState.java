package com.stab.data.animation.state;

import java.awt.Point;

import com.stab.client.slick.base.updaters.SyncState;
import com.tien.princess.engine.Screen;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.common.states.State;

public class MoveToPointState extends State {

    Point target;
    double sx=0;
    double sy=0;
	
	public MoveToPointState(Point p,long time) {
		this.target=p;
		super.setTimed((int)time, SyncState.ID);
	}
	
	
	@Override
	public void enter(Sprite sprite) {
		super.enter(sprite);
		double dx=(target.getX()-sprite.getX());
		double dy=(target.getY()-sprite.getY());
		sx=dx/getTimed();
		sy=dy/getTimed();
	}
	
	@Override
	public String update(Screen world, Sprite sprite, int t) {
		sprite.setPos((float) (sprite.getX()+sx*t),(float) (sprite.getY()+sy*t));
		return super.update(world, sprite, t);
	}
	
	
	@Override
	public void leave(Sprite sprite) {
		sprite.setPos(target);
		super.leave(sprite);
	}
	
}
