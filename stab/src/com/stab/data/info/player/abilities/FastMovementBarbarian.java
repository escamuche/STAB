package com.stab.data.info.player.abilities;

import com.stab.data.info.equipment.Armor;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.player.BarbarianCharacter;
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