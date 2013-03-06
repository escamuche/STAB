package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class RayEnfeeblement extends SpellOnTarget{
	
	public static final String ID="RAYENFEEBLEMENT";

	@Override
	public boolean execute(Info yo, Info target) {
		//falta el RayEnfeeblement_Debuff
		return false;
		}
	
	public RayEnfeeblement() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_shaman_watershield");
     setName("RayEnfeblement");
     this.setEffectType(DEBUFF);
	}
}