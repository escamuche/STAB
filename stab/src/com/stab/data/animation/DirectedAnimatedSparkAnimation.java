package com.stab.data.animation;

import java.awt.Point;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.model.animation.OnTileAnimation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.states.ValueState2;
import com.tien.princess.engine.sprite.common.updaters.conditions.OnRefDestroyed;
import com.tien.princess.engine.utils.PaintUtils;

public class DirectedAnimatedSparkAnimation  extends OnTileAnimation {

	public static final String ID=VisualEffect.DIRECTED_ANIMATED_SPARK_ANIMATION;
	
	
	public DirectedAnimatedSparkAnimation() {
		
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		
		double a=getAngle();
		int dist=32;
		
		String img=getParam(2);
		dist=getIntParam(3);
		int timed= getIntParam(4);
		int i=getIntParam(5);
		int f=getIntParam(6);
		int t=getIntParam(7);
		boolean loop=getBooleanParam(8);
		boolean bounce=getBooleanParam(9);
		
		
		setTime(timed);
		
		
		ValueState2 st= new ValueState2();
		
		if (!bounce){
			if (loop)
				st.setFrameLoop(0,i,t,f);
			else
				st.setFrame(0,i,t,f);
		}else{
			if (loop)
				st.setFrameLoop(0,i,t,f,t*2,i);
			else
				st.setFrame(0,i,t,f,t*2,i);
		}
		st.setRotation((float)Math.toDegrees(a));
	
		StabSprite icon=new StabSprite();
		
		if (timed>0)
			st.setTimed(timed, StateSet.DESTROYED);
		else{
			st.addUpdater(new OnRefDestroyed());
			icon.setRef(AnimUtils.getSprite(getSource()));
		}
		
		Painter p=PaintUtils.getPainter(img);
	
		
		

		Point tp=getOriginPoint();
		Point sp=new Point((int)(tp.x+dist*Math.cos(a)),(int)(tp.y+dist*Math.sin(a)));
		icon.setPos(sp);
		icon.setSize(64,64);
		
		icon.setPainter(p);
		
		icon.setState(st);
		
		
		StateSprite s=AnimUtils.getSprite(getSource());
		((AbstractGameScreen)s.getScreen()).add(icon);
	}

}
