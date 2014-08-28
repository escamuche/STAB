package com.stab.data.animation;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.model.animation.Animation;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.states.ValueState;
import com.tien.princess.engine.sprite.common.states.ValueState2;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;
import com.tien.princess.engine.utils.PaintUtils;

public class DrinkPotionAnimation extends Animation {
	
	public static final String ID="DRINK_POTION_ANIMATION";
	
	public DrinkPotionAnimation() {
		
		setTime(2000);
	}
	
	@Override
	public void start() {
		super.start();
	
		
		
		
		ValueState2 st= new ValueState2();
		
			
		StabSprite icon=new StabSprite();
	
		st.setTimed(getTime(), StateSet.DESTROYED);
		
		icon.setR(32);
		
		st.setAngle(0,(float)Math.toRadians(135),200,(float)Math.toRadians(135),900,(float)Math.toRadians(210));
		st.setAlpha(0,255,1600,255,1900,0);
		st.setRotation(0,0,200,0,900,120,1400,120,1600,0);
		st.setFrame(0,0,250,3,900,4,1400,7);
		
		st.addUpdater(new Orbit());
		
		icon.setRef(AnimUtils.getSprite(getSource()));
		
		
		Painter p=PaintUtils.getPainter("animations/drinkpotion&0");
	
		
		

	
		icon.setPos(getOriginPoint());
		icon.setSize(64,64);
		
		icon.setPainter(p);
		
		icon.setState(st);

		
		StateSprite s=AnimUtils.getSprite(getSource());
		((AbstractGameScreen)s.getScreen()).add(icon);
		
	}

}
