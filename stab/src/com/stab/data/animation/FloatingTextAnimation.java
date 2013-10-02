package com.stab.data.animation;

import org.newdawn.slick.Color;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.common.Constants;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.Resources;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.base.FloatingText;

public class FloatingTextAnimation extends Animation{
	
	public static final String ID=VisualEffect.FLOATING_TEXT_ANIMATION;


	public FloatingTextAnimation() {
		setBlocking(true);
		setTime(200);
	}
	
	@Override
	public void start() {
		super.start();
			
		StateSprite s=AnimUtils.getSprite(getSource());
		if (!s.isVisible()){
			setTime(0);
			return;
		}
		 FloatingText ft=new FloatingText(1000);
		 ft.setText(getParam(0));
		 ft.setDesiredLayer(Constants.OVERMAP);
		 String[] vals= getParam(1).split(",");
		 
		// Color c= new Color(Integer.parseInt(vals[0]),Integer.parseInt(vals[1]),Integer.parseInt(vals[2]),Integer.parseInt(vals[3]));
		 Color c= getT(1, Color.class);
		 ft.setTextColor(c);
		 
		 ft.setFont(Resources.INSTANCE.getFont(Resources.BOLD_FONT));
		 
		
		 
		 ft.setPos(s.getX()+s.getWidth()/2,s.getY()+16);
		 ft.setSize(64,64);
		 ft.setSpeed(0, -0.03f);
		((AbstractGameScreen)s.getScreen()).add(ft);
		
	}
	
	
	
}
