package com.stab.data.info.buff;

import com.stab.common.Constants;
import com.stab.data.actions.player.spells.SpellAction;
import com.stab.data.animation.GenericSpriteOnAnimation;
import com.stab.data.animation.sprite.SpecialEffectsSpriteFactory;
import com.stab.model.action.Action;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.trait.base.Buff;

public class SpellCasting_Condition extends Buff {
	
	public static final String ID="SPELLCASTING";
	
	Action action;
	
	public SpellCasting_Condition(Action action) {
		this.action=action;
	}
	
	
	public Action getAction() {
		return action;
	}
	
	@Override
	protected DecorToken createEffectToken() {
		DecorToken t=createEffectToken(null,Constants.EFFECTS);
		return t;
	}
	
	protected void configureEffectToken(DecorToken token) {
		//En un futuro, usar una animacion distinta para divine casting, y para spell like
		if (action instanceof SpellAction){
			SpellAction a= (SpellAction)action;
			if (a.getSpell().isArcane())
				token.playAnimation(GenericSpriteOnAnimation.ID,SpecialEffectsSpriteFactory.SPELLCASTING);
			if (a.getSpell().isDivine())
				token.playAnimation(GenericSpriteOnAnimation.ID,SpecialEffectsSpriteFactory.DIVINESPELLCASTING);
		}
	}

}
