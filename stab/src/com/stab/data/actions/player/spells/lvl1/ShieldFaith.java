package com.stab.data.actions.player.spells.lvl1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;

public class ShieldFaith extends SpellOnSelf{
	
	public static final String ID="SHIELDFAITH";
	public static final String BUFF_ID="SHIELDFAITH_BUFF";
	
	public ShieldFaith() {
     setResource("actions/shieldfaith");
     setName("Shield of Faith");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
    this.setDescription("This spell creates a shimmering, magical field around the target that averts and deflects attacks. The spell grants the subject a +2 deflection bonus to AC, with an additional +1 to the bonus for every six levels you have (maximum +5 deflection bonus at 18th level).");
     this.setLevel(1);
     this.setDuration(MEDIUM);
     this.setDescriptors(EffectDescriptor.ABJURATION);
	}

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	SpellEffect buff= new SpellEffect(getSpell(),caster);
	buff.setId(BUFF_ID);
	buff.setEvident(true);
	buff.setEffectResource("SHADER#goldshield#effects/globe$S");
	buff.setBuffDebuff(BUFF);
	Modifier ca=new Modifier(StabConstants.ARMORDEFENSE,StabConstants.DEFLECTIONMOD,+2);
	buff.addTrait(ca);
	target.addTrait(buff);
	
	return super.fullEffect(caster, target, point);
}
}

//vec3 c = mix(c1, c2, fbm(p + r)) + mix(c3, c4, r.x) - mix(c5, c6, r.y);
