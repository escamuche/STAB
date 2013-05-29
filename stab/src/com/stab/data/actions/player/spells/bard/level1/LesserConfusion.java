package com.stab.data.actions.player.spells.bard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.condition.ConfuseCondition;
import com.stab.model.info.BaseInfo;

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
	}

		@Override
		protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
			ConfuseCondition d = new ConfuseCondition();
			d.setTime(1);
			target.addTrait(d);
			return super.fullEffect(caster, target, point);
		}


}
