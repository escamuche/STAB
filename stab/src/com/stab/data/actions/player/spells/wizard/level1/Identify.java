package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.Identify_Buff;
import com.stab.model.info.BaseInfo;

public class Identify extends SpellOnSelf{
	
	public static final String ID="IDENTIFY";
	
	public Identify() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setRange(1);
     setResource("actions/ability_druid_naturalperfection");
     setName("Identify");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean execute(BaseInfo caster) {
		
		Identify_Buff buff = new Identify_Buff();
		caster.addTrait(buff);
		return true;
	
	}
}
