package com.stab.data.animation;

import org.newdawn.slick.Color;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.BaseInfo;
import com.tien.princess.engine.sprite.base.FloatingText;

public class DamageNumberAnimation extends Animation{
	
	public static final String ID=BaseInfo.RECEIVE_DAMAGE_ANIMATION;


	public DamageNumberAnimation() {
		setBlocking(false);
	}
	
	@Override
	public void start() {
		super.start();
			
		Token_sprite s=AnimUtils.getSprite(getSource());
		
		 FloatingText ft=new FloatingText();
		 ft.setText(getParam(0));
		 ft.setTextColor(Color.red);
		 ft.setPos(s.getX(),s.getY());
		 ft.setSize(64,64);
		//((GameScreen)s.getScreen()).add(ft);
		 //WIP
	}
	
	
	
}