package com.stab.data.animation;

import org.newdawn.slick.Color;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.common.Constants;
import com.stab.model.animation.Animation;
import com.stab.model.info.BaseInfo;
import com.tien.princess.engine.Resources;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.base.FloatingText;

public class DamageNumberAnimation extends Animation{
	
	public static final String ID=BaseInfo.RECEIVE_DAMAGE_ANIMATION;


	public DamageNumberAnimation() {
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
		 ft.setTextColor(Color.red);
		 ft.setDesiredLayer(Constants.OVERMAP);
		 ft.setFont(Resources.INSTANCE.getFont(Resources.BOLD_FONT));
		 
		 if (getBooleanParam(2))
			 ft.setFont(Resources.INSTANCE.getFont(Resources.BIG_BOLD_FONT));
		 
		 ft.setPos(s.getX()+s.getWidth()/2,s.getY()+16);
		 ft.setSize(64,64);
		 ft.setSpeed(0, -0.03f);
		((AbstractGameScreen)s.getScreen()).add(ft);
		
	}
	
	
	
}