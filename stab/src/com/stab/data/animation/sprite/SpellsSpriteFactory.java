package com.stab.data.animation.sprite;

import java.util.Arrays;
import java.util.Collection;

import com.stab.data.StabInit;
import com.stab.data.actions.player.spells.lvl0.AcidSplash;
import com.stab.data.actions.player.spells.lvl0.DisruptUndead;
import com.stab.data.actions.player.spells.lvl0.RayFrost;
import com.stab.data.animation.state.ExplodeState;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.states.ValueState2;
import com.tien.princess.engine.sprite.common.updaters.sound.LoopSound;
import com.tien.princess.engine.sprite.common.updaters.spawn.SpawnUpdater;
import com.tien.princess.engine.sprite.factory.AbstractSpriteFactory;

public class SpellsSpriteFactory extends AbstractSpriteFactory{

	
	
	@Override
	public Collection<Sprite> getSprites(String type) {
		
		if (AcidSplash.ID.equals(type)){
			StabProyectile s= new StabProyectile(0.2f);
			s.setPainter("PARTICLE#spells/acidOrb");
			s.setOnReach(new ExplodeState(SpecialEffectsSpriteFactory.ACID_EXPLOSION), 16);
			s.setOnFade(new ExplodeState(SpecialEffectsSpriteFactory.ACID_EXPLOSION));
			s.setOnFire(new ExplodeState(SpecialEffectsSpriteFactory.BLUE_CAST));
			//((ValueState2)s.getTravel()).setScale(0.7f); 
			s.setOriented();
			
			return Arrays.asList((Sprite)s);
		}
		if (DisruptUndead.ID.equals(type)){
			StabProyectile s= new StabProyectile(0.3f);
			s.setPainter("PARTICLE#spells/ball1");
			s.getTravel().addUpdater(new LoopSound("effects/ArcaneExplosion"));
			s.setOnReach(new ExplodeState(SpecialEffectsSpriteFactory.BLUE_EXPLOSION), 16);
			s.setOnFade(new ExplodeState(SpecialEffectsSpriteFactory.BLUE_EXPLOSION));
			s.setOnFire(new ExplodeState(SpecialEffectsSpriteFactory.BLUE_CAST));
			((ValueState2)s.getTravel()).setScale(0.7f); 
			s.setOriented();
			//s.getTravel().addUpdater(new AngleToRotation());
			return Arrays.asList((Sprite)s);
		}
		if (RayFrost.ID.equals(type)){
			StabProyectile s= new StabProyectile(0.5f);
			s.setPainter("PARTICLE#effects/blueBeamHead");
			s.setLoopSound("effects/ArcaneExplosion");
			SpawnUpdater beam= new SpawnUpdater(SpecialEffectsSpriteFactory.BLUE_BEAM);
			beam.setFactory(StabInit.getSpriteFactory());
			s.getTravel().addUpdater(beam);
			ExplodeState x=new ExplodeState(SpecialEffectsSpriteFactory.FREEZE_EXPLOSION);
			x.addUpdater(new LoopSound("effects/ArcaneExplosion"));
			x.setTimed(2000, StateSet.DESTROYED);
			SpawnUpdater beam2= new SpawnUpdater(SpecialEffectsSpriteFactory.BLUE_IMPACT,true);
			beam2.setFactory(StabInit.getSpriteFactory());
			x.addUpdater(beam2);
			s.setOnReach(x, 16);
			s.setOnFade(SpecialEffectsSpriteFactory.FREEZE_EXPLOSION);
			s.setOnFire(SpecialEffectsSpriteFactory.BLUE_CHANNEL);
			s.setOriented();
			return Arrays.asList((Sprite)s);
		}
		
		return null;

		
	}
	
}
