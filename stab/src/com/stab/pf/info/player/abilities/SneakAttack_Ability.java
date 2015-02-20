package com.stab.pf.info.player.abilities;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.trait.Trait;
import com.stab.pf.info.applicable.SneakAttack;

public class SneakAttack_Ability extends Trait implements Affects<SneakAttack>{

	
	public static final String ID="SNEAK_ATTACK";
	
	
	int dice=1;
	
	public SneakAttack_Ability(int dice) {
		this.dice=dice;
	}
	
	
	public void setDice(int dice) {
		this.dice = dice;
	}
	public int getDice() {
		return dice;
	}
	
	@Override
	public boolean canAffect(Applicable a) {
		if (a instanceof SneakAttack)
			return true;
		return false;
	}

	@Override
	public void affect(SneakAttack app) {

		BaseInfo target= app.getTarget();
		Info attacker= app.getInstigator();
		
		app.setNumber(dice);
		
	}
	
	


}
