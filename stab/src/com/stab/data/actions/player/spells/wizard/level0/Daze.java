package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.applicable.magic.WillAttack;
import com.stab.data.info.debuff.condition.DazedCondition;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Daze extends SpellOnTarget{
	
	public static final String ID="DAZE";

	
	public Daze() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/ability_druid_naturalperfection");
		setName("Daze");
		this.setEffectType(DEBUFF);
		setRange(CLOSE);
		
	}

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo atacado = (BaseInfo)target;
		BaseInfo caster =(BaseInfo)yo;
		
		WillAttack save = new WillAttack(caster);
		atacado.apply(save);
		int cl =getCasterLevel(caster);
		
		if(save.hits()){
		
			DazedCondition buff = new DazedCondition();
			buff.setTime(1);
			atacado.addTrait(buff);
			return true;
			}
		else
			return false;
		}

	@Override
	public int getEffectValue(BaseInfo i) {
		return 4;
	}
}