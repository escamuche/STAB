package com.stab.data.animation.sprite;

import java.util.Arrays;
import java.util.Collection;

import com.stab.data.StabInit;
import com.stab.data.actions.player.spells.wizard.level0.DisruptUndead;
import com.stab.data.actions.player.spells.wizard.level0.RayFrost;
import com.stab.data.animation.state.ExplodeState;
import com.tien.princess.engine.sprite.AbstractSpriteFactory;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.ProyectileSprite;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.updaters.misc.ChangePainter;
import com.tien.princess.engine.sprite.common.updaters.sound.LoopSound;
import com.tien.princess.engine.sprite.common.updaters.spawn.SpawnUpdater;

public class SpellsSpriteFactory extends AbstractSpriteFactory{

	
	
	@Override
	public Collection<Sprite> getSprites(String type) {
		
		
		if (DisruptUndead.ID.equals(type)){
			ProyectileSprite s= new ProyectileSprite(1000);
			s.setPainter("PARTICLE#spells/ball1");
			s.setR(0.2f);
			s.getTravel().addUpdater(new LoopSound("effects/ArcaneExplosion"));
			s.setOnReach(new ExplodeState(SpecialEffectsSpriteFactory.BLUE_EXPLOSION), 16);
			s.setOnFade(new ExplodeState(SpecialEffectsSpriteFactory.BLUE_EXPLOSION));
			s.setOnFire(new ExplodeState(SpecialEffectsSpriteFactory.BLUE_CAST));
			return Arrays.asList((Sprite)s);
		}
		if (RayFrost.ID.equals(type)){
			StabProyectile s= new StabProyectile(0.05f);
			s.setPainter("PARTICLE#spells/magicmissile");
			s.setLoopSound("effects/ArcaneExplosion");
			SpawnUpdater beam= new SpawnUpdater(SpecialEffectsSpriteFactory.BLUE_BEAM);
			beam.setFactory(StabInit.getSpriteFactory());
			s.getTravel().addUpdater(beam);
			ExplodeState x=new ExplodeState(SpecialEffectsSpriteFactory.BLUE_EXPLOSION);
			x.setTimed(1000, StateSet.DESTROYED);
			x.addUpdater(new ChangePainter("PARTICLE#effects/frostImpact"));
			s.setOnReach(x, 16);
			s.setOnFade(SpecialEffectsSpriteFactory.FREEZE_EXPLOSION);
			s.setOnFire(SpecialEffectsSpriteFactory.BLUE_CHANNEL);
			return Arrays.asList((Sprite)s);
		}
		
		return null;

		
	}
	
}
