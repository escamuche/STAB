package com.stab.data.animation;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.model.animation.OnTileAnimation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.base.AttachedParticleSprite;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.common.painters.ParticleSystemPainter;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.states.base.ClearParticlesState;
import com.tien.princess.engine.utils.PaintUtils;

public class ShockwaveAnimation extends OnTileAnimation {

	public static final String ID=VisualEffect.SPARK_ANIMATION;
	
	
	public ShockwaveAnimation() {
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		int size=getIntParam(2);
		int t=getIntParam(3);
		if (t!=0)
			setTime(t);
		double a=0;
		try{
			a=getT(4, Double.class);
		}catch(Exception e){}
		StateSprite s=AnimUtils.getSprite(getSource());
		/*if (!s.isVisible()){ //En basic no podemos presuponer nada.
			setTime(0);
			return;
		}/**/
		Painter p=PaintUtils.getPainter("SHADERCIRCLE#shockwave");
	
		if (p instanceof ValuePainter)
			((ValuePainter)p).setRotation((float)a);
		
		StateSprite icon=new StabSprite();
		
		
		icon.setState(new BasicAnimState(this.getTime()));
	
		icon.setPos(getOriginPoint());
		icon.setSize(64+(size*128),64+(size*128));
		
		icon.setPainter(p);
		((AbstractGameScreen)s.getScreen()).add(icon);
	}
	
}
