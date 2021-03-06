package com.stab.pf.actions.player.spells.lvl0;

import java.awt.Point;

import com.stab.client.animation.BasicSparkAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTarget;
import com.stab.pf.info.debuff.Bleed_Debuff;

public class Bleed extends SpellOnTarget{
	
	public static final String ID="BLEED_CLERIC";

	public Bleed() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.CLERICCASTER);
		 setRange(5);
	     setResource("actions/bleed");
	     setName("Bleed");
	     this.setEffectType(DEBUFF);
	     this.setSave(StabConstants.WILLSAVE);
	     setDescriptors(EffectDescriptor.NECROMANCY);
	     this.setDescription("You cause a living creature that is below 0 hit points but stabilized to resume dying. Upon casting this spell, you target a living creature that has -1 or fewer hit points. That creature begins dying, taking 1 point of damage per round. The creature can be stabilized later normally. This spell causes a creature that is dying to take 1 point of damage.");
		}

		@Override
		protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
			
			if(target.getHp()<=0) {
			Bleed_Debuff debuff = new Bleed_Debuff();
			target.addTrait(debuff);
			return super.fullEffect(caster, target, point);
		
			}
			else
				return false;
		
	  }
		
		
	@Override
	protected void playFullEffectAnimation(BaseInfo caster, BaseInfo target,
			Point point, ActionRequest ar) {
		super.playFullEffectAnimation(caster, target, point, ar);
		target.playAnimation(BasicSparkAnimation.ID, target.getBloodEffect());
	}	
}
