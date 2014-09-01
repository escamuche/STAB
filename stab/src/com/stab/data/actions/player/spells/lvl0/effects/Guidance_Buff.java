package com.stab.data.actions.player.spells.lvl0.effects;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.ActivateSpellEffectAction;
import com.stab.data.actions.player.spells.Spell;
import com.stab.data.info.applicable.BreakSpellResistance;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.data.info.traits.AllSkillsModifier;
import com.stab.model.action.Action;
import com.stab.model.extras.PlayerContextualOption;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.info.trait.Modifier;

public class Guidance_Buff extends  SpellEffect implements   Attends<SkillRoll>{

	public static final String ID="GUIDANCE_BUFF";
	
	public Guidance_Buff(Spell spell, Info caster) {
		super(spell, caster);
		setBuffDebuff(BUFF);
	}
	
	boolean active=false;
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
		//System.out.println("Activando bono de guidance");
		active=true;
		this.setTime(1);//Expira en un round como mucho
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

	@Override
	public boolean canAttend(Applicable a) {
		if (!active)
			return false;
		if (a instanceof SkillRoll)
			if (!(a instanceof BreakSpellResistance))
				return true;
		return false;
	}

	@Override
	public void attend(SkillRoll app) {
		if (!active)
			return;
		if (app instanceof SkillRoll)
			if (!(app instanceof BreakSpellResistance)){
				app.addModifier(new Modifier(((SkillRoll)app).getSkill(),StabConstants.COMPETENCEMOD, +1));
				this.end();
			}
		
	}
	
	
	
	
}