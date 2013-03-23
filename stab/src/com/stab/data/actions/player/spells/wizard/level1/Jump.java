package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.Jump_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Jump extends SpellOnTarget {
	
	public static final String ID="JUMP";
	
	public Jump() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(1);
     setResource("actions/jump");
     setName("Jump");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean execute(Info caster, Info target) {
		
		BaseInfo buffed = (BaseInfo)target;
		BaseInfo self = (BaseInfo) caster;
		int time= self.getValue(StabConstants.CASTERLEVEL)*10;
		Jump_Buff buff = new Jump_Buff(self,buffed);
		
		buff.setTime(time);
		if(buffed.hasTrait(Jump_Buff.ID) == false)
			buffed.addTrait(buff);
		else
			return false;
		return true;
	}


}
