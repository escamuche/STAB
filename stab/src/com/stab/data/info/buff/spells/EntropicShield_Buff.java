package com.stab.data.info.buff.spells;

import com.stab.common.utils.Roll;
import com.stab.data.info.applicable.PathfinderAttack;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Attack;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.trait.base.Buff;

public class EntropicShield_Buff extends Buff implements Attends<WeaponAttack> {

	public static final String ID="ENTROPICSHIELD_BUFF";
	
	public EntropicShield_Buff() {
	
		
		this.setAnimIcon("actions/ability_shaman_watershield");				
		this.setSound("HolyCast");
		this.setResource("actions/ability_shaman_watershield");                  
		this.setName("Entropic Shield");
		
		}

	@Override
	public void attend(WeaponAttack arg0) {
		
		int i = Roll.d100();
		if(i <= 20) 
			arg0.setResult(Attack.MISS);
		
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		if (arg0 instanceof PathfinderAttack)
			return ((Attack)arg0).isRanged();
		return false;
	}

	

}
