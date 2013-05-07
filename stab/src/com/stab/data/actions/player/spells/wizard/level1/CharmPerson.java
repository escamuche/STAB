package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.CharmPerson_Debuff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class CharmPerson extends SpellOnTarget{
	
	public static final String ID="CHARMPERSON";
	
	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int cl = getCasterLevel(caster);
		int time = cl*60;
		

		CharmPerson_Debuff debuff = new CharmPerson_Debuff();
		debuff.setTime(time);
		target.addTrait(debuff);
		return true;
		}
	
	public CharmPerson() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		
		setResource("actions/charmperson");
		setName("CharmPerson");
		this.setEffectType(DEBUFF);
		setRange(CLOSE);
	
	}
}
