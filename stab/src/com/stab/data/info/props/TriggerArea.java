package com.stab.data.info.props;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;

import com.stab.model.basic.token.interfaces.Area;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;
import com.stab.model.info.base.FloorDecoration;
import com.stab.model.info.trait.base.VisualEffect;

public class TriggerArea extends FloorDecoration implements Area{

	
	Class classLimit;
	
	
	
	@Override
	public void init() {
		super.init();
		setClassLimit(Creature.class);
	}
	
	public void setClassLimit(Class classLimit) {
		this.classLimit = classLimit;
	}
	public Class getClassLimit() {
		return classLimit;
	}
	
	
	@Override
	public boolean canEnter(Info info, Point point) {
		return true;
	}

	@Override
	public boolean canExit(Info info, Point point) {
		return true;
	}

	@Override
	public boolean canMove(Info info, Point point) {
		return true;
	}

	@Override
	public boolean isInside(Point point) {
		return getBounds().contains(point);
	}

	@Override
	public boolean isInside(Rectangle r) {
		return getBounds().intersects(r);
	}

	@Override
	public Collection<Point> getPoints() {
		return getMapLogic().getPointsInRect(getBounds());
	}

	@Override
	public boolean isInside(Info info) {
		return info.getBounds().intersects(this.getBounds());
	}

	@Override
	public void infoEnters(Info info) {
		if (getState()==OFF)
			return;
		if (!willTrigger(info))
			return;
		if (this.isHiddenFrom(info)&&(info instanceof BaseInfo)){
			((BaseInfo)info).clearActions();
			info.playAnimation(VisualEffect.ALERT_ANIMATION);
			revealFor(info);
		}
		
		onEnter(info);
	}


	protected boolean willTrigger(Info info) {
		if (!(classLimit.isAssignableFrom(info.getClass())))
			return false;
		return true;
	}

	protected void onEnter(Info info) {
		
	}

	@Override
	public void infoLeaves(Info info) {
		
	}

	@Override
	public void infoMoves(Info info) {
		
	}

}
