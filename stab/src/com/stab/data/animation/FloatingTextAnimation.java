package com.stab.data.animation;

import org.newdawn.slick.Color;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.Resources;
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
			
		Token_sprite s=AnimUtils.getSprite(getSource());
		
		 FloatingText ft=new FloatingText(1000);
		 ft.setText(getParam(0));
		 
		 String[] vals= getParam(1).split(",");
		 
		// Color c= new Color(Integer.parseInt(vals[0]),Integer.parseInt(vals[1]),Integer.parseInt(vals[2]),Integer.parseInt(vals[3]));
		 Color c= getT(1, Color.class);
		 ft.setTextColor(c);
		 
		 ft.setFont(Resources.INSTANCE.getFont(Resources.BOLD_FONT));
		 
		
		 
		 ft.setPos(s.getX()+s.getWidth()/2,s.getY()+16);
		 ft.setSize(64,64);
		 ft.setSpeed(0, -0.03f);
		((GameScreen)s.getScreen()).add(ft);
		
	}
	
	
	
}