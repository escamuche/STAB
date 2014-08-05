package com.stab.data.actions.player.spells;

import java.awt.Point;

import org.newdawn.slick.Color;

import com.stab.common.Constants;
import com.stab.data.animation.GenericSpriteOnAnimation;
import com.stab.data.animation.sprite.SpecialEffectsSpriteFactory;
import com.stab.data.info.applicable.SpellCasting;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.Info;
import com.stab.model.info.trait.base.activity.ProgressActivity;

public class SpellCastingActivity extends ProgressActivity {

public static final String ID="SPELLCASTING";
	
SpellAction action;
Spell spell;
	
	public SpellCastingActivity(SpellAction action) {
		this.action=action;
		this.setMaxProgress(1);
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
		//	endCasting(origin);
			if (sc.failed()){
				switch(sc.getResult()){
					case SpellCasting.ARMORFAIL: 
					case SpellCasting.INDUCEDFAIL:
					case SpellCasting.CONCENTRATIONFAIL:
					case SpellCasting.SPELLCHECKFAIL:
					case SpellCasting.GENERICFAIL:
							getTarget().showFloatingText("FAILED", Color.red);
				}
				return false;
			}
			spell=sc.getSpell();
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
			}
		
			return super.shouldEndTurn();
		}
	
}
