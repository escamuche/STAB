package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.Shield_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Shield extends SpellOnSelf{
	
	public static final String ID="Shield";
	
	public Shield() {
     //setRange(4);
     setResource("actions/shield");
     setName("Shield");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.WIZARDCASTER);
     this.setDescription("Shield creates an invisible shield of force that hovers in front of you. It negates magic missile attacks directed at you. The disk also provides a +4 shield bonus to AC. This bonus applies against incorporeal touch attacks, since it is a force effect. The shield has no armor check penalty or arcane spell failure chance.");
	 this.setLevel(1);
	}

	@Override
	public boolean affect(Info instigator,Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receptor;
		
		Shield_Buff buff = new Shield_Buff();
		buff.setTime(getCasterLevel(caster)*10);
		target.addTrait(buff);
		
		return true;
	}
}
	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/