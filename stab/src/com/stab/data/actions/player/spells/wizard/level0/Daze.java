package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.applicable.magic.WillAttack;
import com.stab.data.info.debuff.condition.DazedCondition;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Daze extends SpellOnTarget{
	
	public static final String ID="DAZE";

	
	public Daze() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		
		setResource("actions/ability_druid_naturalperfection");
		setName("Daze");
		this.setEffectType(DEBUFF);
		setRange(CLOSE);
		
	}

	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		WillAttack save = new WillAttack(caster);
		target.apply(save);
		int cl =getCasterLevel(caster);
		
		if(save.hits()){
		
			DazedCondition buff = new DazedCondition();
			buff.setTime(1);
			target.addTrait(buff);
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