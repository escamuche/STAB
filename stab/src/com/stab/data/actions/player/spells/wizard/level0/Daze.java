package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.condition.DazedCondition;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Daze extends SpellOnTarget{
	
	public static final String ID="DAZE";

	
	public Daze() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setRange(6);
		setTargetClass(PhysicalToken.class);
		setResource("actions/ability_druid_naturalperfection");
		setName("Daze");
		this.setEffectType(BUFF);
	}

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacado = (BaseInfo)target;
		DazedCondition buff = new DazedCondition();
		buff.setTime(1);
		Atacado.addTrait(buff);
		return true;
		}

	@Override
	public int getEffectValue(BaseInfo i) {
		return 4;
	}
}