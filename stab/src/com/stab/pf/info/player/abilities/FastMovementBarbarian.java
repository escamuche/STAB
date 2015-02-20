package com.stab.pf.info.player.abilities;

import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.info.equipment.Armor;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.player.BarbarianCharacter;

public class FastMovementBarbarian extends BuffEffect {
	
	public static final String ID="BARBARIANFASTMOVEMENT_BUFF";
	
	public FastMovementBarbarian() {
				
		this.setSound("HolyCast");          
		this.setName("Fast Movement");
		this.setUnique(true);
		this.setPermanent();
		
		}
	
	@Override
	public void turnStarts() { 
		
		BarbarianCharacter i = (BarbarianCharacter) getTarget(); 
		boolean v = false;
		super.turnStarts();
		if (i.getEquipment(HumanoidGear.ARMOR) instanceof Armor) {
			Armor a = (Armor)i.getEquipment(HumanoidGear.ARMOR);
			if(a.getCategory()<Armor.HEAVY_ARMOR){
				v = true;
				
			}
			
		}

		else {
			v = true;
		}
		
		if (v == true){
			
			i.setMovePoints(i.getMovePoints()+2);
		}
	}
}