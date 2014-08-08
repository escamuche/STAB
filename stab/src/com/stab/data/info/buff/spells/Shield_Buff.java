package com.stab.data.info.buff.spells;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.magic.MagicMissileAttack;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;

public class Shield_Buff extends BuffEffect implements Attends<MagicMissileAttack>{

	public static final String ID="SHIELD_BUFF";
	
	public Shield_Buff() {
	
		
		this.setAnimIcon("actions/shield");				
		this.setSound("HolyCast");
		this.setResource("actions/shield");                  
		this.setName("Shield");
	
		Modifier ca=new Modifier(StabConstants.SHIELDDEFENSE,StabConstants.SHIELDMOD,+4);
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