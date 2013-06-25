package com.stab.data.animation.sprite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.stab.common.Constants;
import com.stab.common.value.InterpolatorValueProvider;
import com.tien.princess.engine.Resources;
import com.tien.princess.engine.sprite.AbstractSpriteFactory;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.base.AttachedParticleSprite;
import com.tien.princess.engine.sprite.base.BeamSprite;
import com.tien.princess.engine.sprite.common.states.ValueState2;
import com.tien.princess.engine.sprite.common.states.base.ClearParticlesState;
import com.tien.princess.engine.sprite.common.updaters.angle.MoveA;
import com.tien.princess.engine.sprite.common.updaters.conditions.OnRefDestroyed;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;
import com.tien.princess.engine.sprite.common.updaters.pos.StickToRef;
import com.tien.princess.engine.sprite.common.updaters.sound.PlaySound;

public class SpecialEffectsSpriteFactory extends  AbstractSpriteFactory{

	
	public static final String DAZED="DAZED";
	
	public static final String BLUE_CAST="BLUECAST";
	public static final String BLUE_EXPLOSION="BLUEEXPLOSION";
	public static final String BLUE_CHANNEL="BLUECHANNEL";
	public static final String BLUE_IMPACT="BLUEIMPACT";
	public static final String BLUE_BEAM="BLUEBEAMT";
	
	
	public static final String FREEZE_EXPLOSION="FEEZEEXPLOSION";
	public static final String ACID_EXPLOSION="ACIDEXPLOSION";
	
	//-----------------------------
	
	protected Collection<Sprite> getSpark(String painter){
		return getSpark(painter,null,1000);
	}
	protected Collection<Sprite> getSpark(String painter,String sound){
		return getSpark(painter,sound,1000);
	}
	protected Collection<Sprite> getSpark(String painter,String sound,long t){
		AttachedParticleSprite s= new AttachedParticleSprite();
		s.setPainter(painter);
		
		s.getCurrentState().setTimed(t, ClearParticlesState.ID);
		if (sound!=null){
		//	System.out.println("preparing sound "+sound+" in "+s);
			s.getCurrentState().addUpdater(new PlaySound(sound));
		}
		return Arrays.asList((Sprite)s);
	}
	
	@Override
	public Collection<Sprite> getSprites(String type) {
		ArrayList<Sprite> all= new ArrayList<Sprite>();
		
		if (DAZED.equals(type)){
			StateSprite s=new StateSprite();
			ValueState2 st= new ValueState2();
			st.addUpdater(new StickToRef(true));
			st.addUpdater(new OnRefDestroyed());
			s.setState(st);
			all.add(s); 
			int nstars=6;
			for (int f=0;f<nstars;f++){
				StateSprite star=new StateSprite();
				st= new ValueState2();
				star.setA(Math.PI*2/nstars*f);
				star.setR(24);
				star.setSa((float)(Math.PI*2/1000));
				star.setPainter("effects/dazeStar");
				st.addUpdater(new Orbit(0.5f));
				st.addUpdater(new MoveA());
				st.addUpdater(new OnRefDestroyed());
				InterpolatorValueProvider i= new InterpolatorValueProvider(f*150,0.6f,f*150+250,0.3f);
				i.setLoops(true);
				st.setScale(i);
				star.setState(st);
				star.setRef(s);
				all.add(star);
			}
			return all;
		}
		
		
		if (BLUE_CAST.equals(type)){
			return getSpark("PARTICLE#effects/blueCast","effects/FizzleNatureA");
		}
		if (BLUE_EXPLOSION.equals(type)){
			return getSpark("PARTICLE#effects/blueSparks","effects/IceCast");
		}
		if (ACID_EXPLOSION.equals(type)){
			return getSpark("PARTICLE#effects/acidExplosion","effects/IceCast");
		}
		if (FREEZE_EXPLOSION.equals(type)){
			return getSpark("PARTICLE#effects/freeze","effects/IceCast");
		}
		if (BLUE_IMPACT.equals(type)){
			return getSpark("PARTICLE#effects/frostImpact","effects/FizzleNatureA");
		}
		if (BLUE_CHANNEL.equals(type)){
			AttachedParticleSprite s= new AttachedParticleSprite();
			s.setPainter("PARTICLE#effects/blueChannel");
			((ValueState2)s.getCurrentState()).setScale(0.5f);
			return Arrays.asList((Sprite)s);
		}
		if (BLUE_BEAM.equals(type)){
			BeamSprite s= new BeamSprite();
			s.setImage(Resources.INSTANCE.getImage("effects/frostBeam"));
			s.setStyle(Constants.TILED);
			s.getFireState().setAlpha(new InterpolatorValueProvider(0,0.1f,100,0.8f));
			s.getFireState().setWidth(new InterpolatorValueProvider(0,0,200,8));
			s.getFadeState().setWidth(new InterpolatorValueProvider(0,8,400,0));
			s.getFadeState().setAlpha(new InterpolatorValueProvider(0,0.6f,500,0f));
			return Arrays.asList((Sprite)s);
		}
		
		return null;
	}
}
