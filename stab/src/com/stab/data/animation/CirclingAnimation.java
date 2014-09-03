package com.stab.data.animation;

import org.newdawn.slick.Color;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.base.AttachedParticleSprite;
import com.tien.princess.engine.sprite.base.TrailSprite;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.common.painters.ParticleSystemPainter;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.states.base.ClearParticlesState;
import com.tien.princess.engine.sprite.common.updaters.conditions.OnRefDestroyed;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;
import com.tien.princess.engine.utils.PaintUtils;

public class CirclingAnimation extends Animation{

	public static final String ID=VisualEffect.CIRCLING_ANIMATION;
	
	
	public CirclingAnimation() {
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		String img=getParam(0);
		int t=getIntParam(1);
		setTime(t);
	
		
		double a=0;
		try{
			a=getT(2, Double.class);
		}catch(Exception e){}
		double sa=0;
		try{
			sa=getT(3, Double.class);
		}catch(Exception e){}
		
		Color col=null;
		try{
			col=getT(4,Color.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		StateSprite s=AnimUtils.getSprite(getSource());
		
		Painter p=PaintUtils.getPainter(img);
	
		if (p instanceof ValuePainter)
			((ValuePainter)p).setRotation((float)a);
		
		StateSprite icon=new StabSprite();
		
		if (p instanceof ParticleSystemPainter){
			icon=new AttachedParticleSprite();
			BasicAnimState st=new BasicAnimState(this.getTime());
			st.setTimed(this.getTime(), ClearParticlesState.ID);
			icon.setState(st);
			
		}
		else{
			icon.setState(new BasicAnimState(this.getTime()));
		}
		//icon.setPos(getOriginPoint());
		icon.setSize(16,16);
		icon.setA(a);
		icon.setRef(s);
		icon.setSa((float)sa);
		icon.getCurrentState().addUpdater(new Orbit());
		icon.getCurrentState().addUpdater(new OnRefDestroyed());
		icon.setR(s.getWidth()/2);
		icon.setPainter(p);
		((AbstractGameScreen)s.getScreen()).add(icon);
		
		if (col!=null){
			TrailSprite trail = new TrailSprite(col,12,6,50);
			trail.setRef(icon);
			AnimUtils.getScreen(getSource()).add(trail);
		}
	}
	
}
