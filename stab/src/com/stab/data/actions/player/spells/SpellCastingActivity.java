package com.stab.data.actions.player.spells;

import com.stab.common.Constants;
import com.stab.data.animation.GenericSpriteOnAnimation;
import com.stab.data.animation.sprite.SpecialEffectsSpriteFactory;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.trait.base.activity.ProgressActivity;

public class SpellCastingActivity extends ProgressActivity {

public static final String ID="SPELLCASTING";
	
SpellAction action;
	
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
	
	
}
