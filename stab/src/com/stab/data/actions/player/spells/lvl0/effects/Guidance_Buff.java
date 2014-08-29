package com.stab.data.actions.player.spells.lvl0.effects;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.ActivateSpellEffectAction;
import com.stab.data.actions.player.spells.Spell;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.data.info.traits.AllSkillsModifier;
import com.stab.model.action.Action;
import com.stab.model.extras.PlayerContextualOption;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Guidance_Buff extends  SpellEffect implements Buff{

	public static final String ID="GUIDANCE_BUFF";
	
	public Guidance_Buff(Spell spell, Info caster) {
		super(spell, caster);
		
	}
	
	
	Action act;
	PlayerContextualOption opt;
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		
		act=new ActivateSpellEffectAction(this);
		act.setDescription("Spend the +1 competence bonus from guidance spell on the next attack, skill or saving throw roll");
		opt=new PlayerContextualOption();
		
		opt.setAction(act);
		
		baseInfo.addExtra(opt);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		
		baseInfo.removeExtra(opt);
	}
	
	
	@Override
	public void activate(int slot, BaseInfo instigator, Info target, Point point) {
		super.activate(slot, instigator, target, point);
		System.out.println("Activando bono de guidance");
		instigator.removeExtra(opt);
	}
	
	
	public void activate(){
	
		Modifier tohit=new Modifier(StabConstants.TOHIT,StabConstants.COMPETENCEMOD, +1);
		Modifier fsave=new Modifier(StabConstants.FORTITUDESAVE,StabConstants.COMPETENCEMOD, +1);
		Modifier rsave=new Modifier(StabConstants.REFLEXSAVE,StabConstants.COMPETENCEMOD, +1);
		Modifier wsave=new Modifier(StabConstants.WILLSAVE,StabConstants.COMPETENCEMOD, +1);
		AllSkillsModifier s = new AllSkillsModifier(StabConstants.COMPETENCEMOD, +1);
		
		
		
		addTrait(tohit);
		addTrait(fsave);
		addTrait(rsave);
		addTrait(wsave);
		addTrait(s);
				
		}
	
	
	
	
}