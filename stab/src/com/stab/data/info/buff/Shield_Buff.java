package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.MagicMissileAttack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Shield_Buff extends Buff implements Attends<MagicMissileAttack>{

	public static final String ID="SHIELD_BUFF";
	
	public Shield_Buff(BaseInfo atacante) {
	
		
		this.setAnimIcon("actions/ability_shaman_watershield");				
		this.setSound("HolyCast");
		this.setResource("actions/ability_shaman_watershield");                  
		this.setName("Shield");
		
		this.setTime(10);
	
		Modifier ca=Modifier.createMod(StabConstants.ARMOR, +4);
		addTrait(ca);
		}

	@Override
	public void attend(MagicMissileAttack misil) {
		misil.setResult(Applicable.NEUTRALIZED);
	}

	@Override
	public boolean canAttend(Applicable a) {
		return a instanceof MagicMissileAttack;
	}



}