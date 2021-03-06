package com.stab.pf.actions.player.spells.lvl1;

import java.awt.Point;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTarget;
import com.stab.pf.actions.player.spells.lvl1.effects.Doom_Debuff;

public class Doom extends SpellOnTarget {
	
	public static final String ID="DOOM";

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		int cl=getCasterLevel(caster);
		
		Doom_Debuff debuff = new Doom_Debuff(getSpell(),caster);
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
     this.setDuration(MEDIUM);
     this.setDescriptors(EffectDescriptor.NECROMANCY,EffectDescriptor.FEAR,EffectDescriptor.MIND_AFFECTING);
	}

	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 5;
	}
	

}
