package com.stab.data.animation;

import java.awt.Point;
import java.util.Collection;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.model.animation.OnTileAnimation;
import com.stab.pf.StabInit;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.TagPoint;


public class GenericSpriteAnimation extends OnTileAnimation {

	public static final String ID="GENERICSPRITE_ANIMATION";
	
	public GenericSpriteAnimation() {
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		
		String img=getParam(2);
		
		Point origin=getOriginPoint();
		Point target=getTargetPoint();
		
		Collection<Sprite> sprites= StabInit.getSpriteFactory().getSprites(img);
		if (sprites==null){
			setTime(0);
			return;
		}
		Sprite first=sprites.iterator().next();
		first.setPos(target);
		
		
		if (getTargetPoint()!=null){
			TagPoint tp= new TagPoint();
			tp.setPos(getTargetPoint());
			first.setRef(tp);
	
		}
		
	
		for (Sprite icon:sprites)
			AnimUtils.getScreen(getSource()).add(icon);
		
		
		
	}
	
}
