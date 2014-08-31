package com.stab.data.actions.player.spells;

import org.newdawn.slick.Color;

import com.stab.common.Constants;
import com.stab.data.StabConstants;
import com.stab.data.animation.GenericSpriteOnAnimation;
import com.stab.data.animation.sprite.SpecialEffectsSpriteFactory;
import com.stab.data.info.spellcasting.SpellCasting;
import com.stab.data.utils.PathfinderUtils;
import com.stab.model.ai.senses.SightSense;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.info.base.Creature;
import com.stab.model.info.interfaces.PlayerOwned;
import com.stab.model.info.trait.base.activity.ProgressActivity;
import com.stab.util.StabUtils;

public class SpellCastingActivity extends ProgressActivity {

public static final String ID="SPELLCASTING";
	
SpellAction action;
Spell spell;
	
	public SpellCastingActivity(SpellAction action) {
		this.action=action;
		this.setMaxProgress(1);
		setInterruptable(true);
	}
	
	
	public SpellAction getAction() {
		return action;
	}
	
	@Override
	protected Sprite createEffectSprite() {
		DecorToken t=createEffectToken(null,Constants.EFFECTS);
		return t;
	}
	
	@Override
	protected void configureEffectSprite(Sprite token) {
		//En un futuro, usar una animacion distinta para divine casting, y para spell like
		if (!action.getSpell().isSpellLikeAbility()){
			if (action.getSpell().isArcane())
				token.playAnimation(GenericSpriteOnAnimation.ID,SpecialEffectsSpriteFactory.SPELLCASTING);
			if (action.getSpell().isDivine())
				token.playAnimation(GenericSpriteOnAnimation.ID,SpecialEffectsSpriteFactory.DIVINESPELLCASTING);
		}
		
	}

	
	@Override
		public void advanceActivity() {
			getTarget().waitAnimation(200);
			super.advanceActivity();
			}
	
	
	@Override
		public void startActivity() {
			super.startActivity();
			boolean b=attemptCast();
			if (!b){
				cancelActivity();
				return;
			}
				
		}
	
	public boolean attemptCast(){
			SpellCasting sc= new SpellCasting(getTarget(),this.action.getBaseSpell());
			sc.check();
			if (sc.failed()){
				switch(sc.getResult()){
					case SpellCasting.ARMORFAIL: 
					case SpellCasting.INDUCEDFAIL:
					case SpellCasting.CONCENTRATIONFAIL:
					case SpellCasting.SPELLCHECKFAIL:
					case SpellCasting.GENERICFAIL:
							getTarget().showFloatingText("FAILED", Color.orange);
				}
				return false;
			}
			spell=sc.getSpell();
			spell.setAction(getAction());
			spell.setFinalCasterLevel(spell.getCasterLevel(getTarget()));
			if (this.getTarget() instanceof PlayerOwned)
				spell.setIdentified(true);
			else{
				//Intento de identificarlo por parte de todos los casters cercanos. Por ahora, de los casters Jugadores
				//en un futuro, hacer que los monstruos tiren para obtener informacion? o colocar directamente en su actionPerformed?
				//mas bien en "actionPerformedDelanteDeSusNarices".  <--- eso
				boolean identified=false;
				for (Creature c:PathfinderUtils.getCreaturesSensing(this.getTarget(), SightSense.class))
					if (c instanceof PlayerOwned && !identified){
						SkillRoll sk=StabUtils.getGameLogic().getSkillRoll(c, StabConstants.SPELLCRAFT, 10+spell.getLevel());
						sk.check();
						identified=sk.success();
					}
				if (identified)
					spell.setIdentified(true);
			}
			this.setMaxProgress(sc.getSpell().getCastingTime()+1);
			action.setSpell(sc.getSpell());//Cambiamos las propiedades del hechizo por las que han resultado del spellcasting (inicialmente una copia
											//pero cualquier attends puede haberlo modiifcado (ie: sumar caster lelvel, etc)
			return true;
		}
	
	
	@Override
		public boolean shouldEndTurn() {
			if (spell!=null){
				if (spell.getCastingTime()==SpellProperties.INSTANT)
					return false;
				if (spell.getCastingTime()==SpellProperties.STANDARD)
					return true;
			}
		
			return super.shouldEndTurn();
		}
	
	@Override
	protected void receivedDamage(Damage d) {
		/*
		SkillRoll cr=StabUtils.getGameLogic().getSkillRoll(this.getTarget(), StabConstants.CONCENTRATION, d.getFinalAmount()+10);
		cr.check();
		if (cr.failed()){
			getTarget().showFloatingText("CONCENTRATION LOSS", Color.orange);
			cancelActivity();
		}
		/**/
	}
	
}
