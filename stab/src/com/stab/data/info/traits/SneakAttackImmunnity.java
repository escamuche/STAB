package com.stab.data.info.traits;

import com.stab.data.info.applicable.SneakAttack;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.AdvancedTrait;

public class SneakAttackImmunnity extends AdvancedTrait  implements Attends<SneakAttack>{

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof SneakAttack)
			return true;
		return false;
	}

	@Override
	public void attend(SneakAttack app) {
		app.setResult(Applicable.INMUNE);
	}

	
	
	//TODO: ver la parte de aitrait... algo retorcido... es para valorar no hacer sneak a alguien de tu misma clase... muy raro
}
