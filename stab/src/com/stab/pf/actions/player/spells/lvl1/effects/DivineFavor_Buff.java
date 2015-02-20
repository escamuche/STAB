package com.stab.pf.actions.player.spells.lvl1.effects;

import java.awt.Color;

import com.stab.model.basic.Sprite;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.Spell;
import com.stab.pf.info.spellcasting.SpellEffect;

public class DivineFavor_Buff extends SpellEffect {

	public static final String ID="DIVINEFAVOR_BUFF";
	
	public DivineFavor_Buff(Spell spell,BaseInfo caster) {
		super(spell,caster);
		setTime(10);
		setEffectResource("blank");
		setBuffDebuff(BUFF);
		int cl=spell.getFinalCasterLevel();
		setEvident(true);
		int bono = (cl/3)+1;
		if(bono > 3)
			bono=3;
		
		Modifier tohit=new Modifier(StabConstants.TOHIT,StabConstants.LUCKMOD, bono);
		Modifier tohitranged=new Modifier(StabConstants.TOHITRANGED,StabConstants.LUCKMOD, bono);
		Modifier damage=new Modifier(StabConstants.DAMAGE,StabConstants.LUCKMOD, bono);
		Modifier damageranged=new Modifier(StabConstants.DAMAGERANGED,StabConstants.LUCKMOD, bono);
		
		addTrait(tohit);
		addTrait(tohitranged);
		addTrait(damage);
		addTrait(damageranged);
		
		}
	
	
	@Override
	protected void configureEffectSprite(Sprite es) {
		super.configureEffectSprite(es);
		es.playAnimation(VisualEffect.CIRCLING_ANIMATION,"effects/yellowSpark$S",0,0,0.004,Color.yellow);
	}
	
}