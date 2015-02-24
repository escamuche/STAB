package com.stab.pf.actions.player.spells.lvl1;

import java.awt.Point;

import com.stab.client.animation.BasicSparkAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTarget;
import com.stab.pf.info.debuff.condition.ConfuseCondition;

public class LesserConfusion extends SpellOnTarget{

	public static final String ID="LESSERCONFUSION";
	
	public LesserConfusion() {
		
		 setLevel(1);
		 setCasterClass(StabConstants.BARDCASTER);
	     setResource("actions/lesserconfusion");
	     setName("Lesser Confusion");
	     this.setEffectType(SPECIAL);
	     this.setDescription("This spell causes a single creature to become confused for 1 round.");
	     this.setSave(StabConstants.WILLSAVE);
	     this.setRange(CLOSE);
	     this.setDescriptors(EffectDescriptor.ENCHANTMENT, EffectDescriptor.COMPULSION,EffectDescriptor.MIND_AFFECTING);
	}

		@Override
		protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
			ConfuseCondition d = new ConfuseCondition();
			d.setTime(1);
			target.addTrait(d);
			return super.fullEffect(caster, target, point);
		}

		@Override
		public void playExecuteActionAnimation(Info caster, Info target,
				Point pos,ActionRequest ar) {
			super.playExecuteActionAnimation(caster, target, pos, ar);
			target.playAnimation(BasicSparkAnimation.ID,"PARTICLE#spells/swirl");
			target.playSound("effects/Curse");
		}
}
