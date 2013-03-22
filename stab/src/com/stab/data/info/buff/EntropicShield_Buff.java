package com.stab.data.info.buff;

import com.stab.data.info.applicable.Attack;
import com.stab.data.info.applicable.RangedAttack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.Buff;
import com.stab.util.Roll;

public class EntropicShield_Buff extends Buff implements Attends<RangedAttack> {

	public static final String ID="ENTROPICSHIELD_BUFF";
	
	public EntropicShield_Buff(BaseInfo caster) {
	
		
		this.setAnimIcon("actions/ability_shaman_watershield");				
		this.setSound("HolyCast");
		this.setResource("actions/ability_shaman_watershield");                  
		this.setName("Entropic Shield");
		
		this.setTime(10);
		}

	@Override
	public void attend(RangedAttack arg0) {

		int i = Roll.d100();
		if(i <= 20) 
			arg0.setResult(Attack.MISS);
		
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
