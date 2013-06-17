package com.stab.data.animation;

import sun.misc.Cleaner;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.base.AttachedParticleSprite;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.common.painters.ParticleSystemPainter;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.states.base.ClearParticlesState;
import com.tien.princess.engine.utils.PaintUtils;

public class BasicSparkAnimation extends Animation {

	public static final String ID=VisualEffect.SPARK_ANIMATION;
	
	public BasicSparkAnimation() {
		setBlocking(false);
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		String img=getParam(0);
		int t=getIntParam(1);
		if (t!=0)
			setTime(t);
		double a=0;
		try{
			a=getT(2, Double.class);
		}catch(Exception e){}
		Token_sprite s=AnimUtils.getSprite(getSource());
		
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
		icon.setPos(getOriginPoint());
		icon.setSize(64,64);
		
		icon.setPainter(p);
		((GameScreen)s.getScreen()).add(icon);
	}
}
