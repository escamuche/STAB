package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.Doom_Debuff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Doom extends SpellOnTarget {
	
	public static final String ID="DOOM";

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		int cl=getCasterLevel(caster);
		
		Doom_Debuff debuff = new Doom_Debuff();
		debuff.setTime(cl*10);
		target.addTrait(debuff);
		return super.fullEffect(caster, target, point);
	}
	
	public Doom() {
    
     
     setResource("actions/doom");
     setName("Doom");
     this.setCasterClass(StabConstants.CLERICCASTER);
     this.setEffectType(DEBUFF);
     setRange(MEDIUM);
     this.setDescription("This spell fills a single subject with a feeling of horrible dread that causes it to become shaken.");
     this.setLevel(1);
     this.setSave(StabConstants.WILLSAVE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 10;
	}
	

}
