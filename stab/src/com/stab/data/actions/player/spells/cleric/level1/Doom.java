package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.applicable.magic.WillAttack;
import com.stab.data.info.debuff.Doom_Debuff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Doom extends SpellOnTarget {
	
	public static final String ID="DOOM";

	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int cl=getCasterLevel(caster);
		
		WillAttack ataque = new WillAttack(caster);
		if(ataque.hits()) {
			Doom_Debuff debuff = new Doom_Debuff();
			debuff.setTime(cl*10);
			target.addTrait(debuff);
			return true;
			}
		return false;
		}
	
	public Doom() {
    
     
     setResource("actions/doom");
     setName("Doom");
     this.setCasterClass(StabConstants.CLERICCASTER);
     this.setEffectType(DEBUFF);
     setRange(MEDIUM);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 10;
	}
	

}
