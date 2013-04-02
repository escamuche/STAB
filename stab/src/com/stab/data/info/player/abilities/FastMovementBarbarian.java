package com.stab.data.info.player.abilities;

import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.Buff;

public class FastMovementBarbarian extends Buff {
	
	public static final String ID="BARBARIANFASTMOVEMENT_BUFF";
	
	public FastMovementBarbarian() {
				
		this.setSound("HolyCast");          
		this.setName("Fast Movement");
		this.setUnique(true);
		this.setPermanent();
		
		}
	
	@Override
	public void turnStarts() { 
		
		Creature i = (Creature) getTarget(); 
		// como se comprueba el tipo de armadura que lleva equipada?
		super.turnStarts();
		int m=i.getMovePoints();
		i.setMovePoints(m+2);
		
	}
}