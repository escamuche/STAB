package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.info.buff.Shield_Buff;
import com.stab.data.info.buff.TrueStrike_Buff;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class TrueStrike extends TargetAction{
	
	public static final String ID="TrueStrike";

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo caster = (BaseInfo)yo;
		
		TrueStrike_Buff buff = new TrueStrike_Buff(caster);
		caster.addTrait(buff);
		
		return true;
		}
	
	public TrueStrike() {
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_shaman_watershield");
     setName("TrueStrike");
     this.setEffectType(BUFF);
	}
}