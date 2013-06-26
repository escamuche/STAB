package com.stab.data.animation;

import java.util.Collection;

import com.stab.data.StabInit;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.StateSprite;

public class GenericSpriteOnAnimation extends Animation {

	public static final String ID="GENERICSPRITEON_ANIMATION";
	
	public GenericSpriteOnAnimation() {
		setBlocking(false);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		
		String img=getParam(0);
		
		
		StateSprite s=AnimUtils.getSprite(getSource());
		
		Collection<Sprite> sprites= StabInit.getSpriteFactory().getSprites(img);
		if (sprites==null){
			setTime(0);
			return;
		}
		Sprite first=sprites.iterator().next();
		first.setPos(s.getPos());
		
		
			first.setRef(s);
		
	
		for (Sprite icon:sprites)
			AnimUtils.getScreen(getSource()).add(icon);
		
		
		
	}
	
	
}
