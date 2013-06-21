package com.stab.data.info.monster.abilities;

import com.stab.model.info.applicable.base.Heal;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.Buff;
import com.stab.model.info.trait.base.VisualEffect;

public class FastHealing extends Buff {
	
	public static final String ID="FASTHEALING_BUFF";
	int c = 0;
	
	public FastHealing(int amount) {
				
		this.setSound("HolyCast");          
		this.setName("Fast Healing");
		this.setUnique(true);
		this.setPermanent();
		c=amount;
		
		}
	
	@Override
	public void turnStarts() { 
		
		Creature i = (Creature) getTarget(); 
		Heal h = new Heal(c,i);
		i.apply(h);
		i.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#effects/healing");
		
	}
}