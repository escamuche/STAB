package com.stab.data.info.debuff.condition;

import java.awt.Color;

import com.stab.common.Constants;
import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.info.trait.base.DebuffEffect;

public class ConfuseCondition extends DebuffEffect {

	public static final String ID="CONFUSECONDITION_DEBUFF";
	BaseInfo target=null;
	
	public ConfuseCondition() {
		
		this.setName("Confused");
		target = getTarget();
		
		
	}
	
	@Override
	public void turnStarts() {
		
		int t = Roll.d4();
		
		if(t==2){
			target.showFloatingText("Confused: no action",Color.yellow);
			target.isTurnDone();
		}
		if(t==3){
			RolledDamage damage = new RolledDamage(1,8,target.getAttributeValue(StabConstants.STRENGHT),target);
			target.showFloatingText("Confused: Hurt self",Color.yellow);
			target.apply(damage);
			target.isTurnDone();
		}
		if(t==4){
			//aqui atacar a lo mas cercano
			//Implicara cambiar el aipackage, la faccion, etc (añadiendo otro debuff)
		}
		
		
		super.turnStarts();
	}

	@Override
	protected Sprite createEffectSprite() {
		DecorToken t=createEffectToken(null,Constants.EFFECTS);
		t.setResource("PARTICLE#effects/confused");
		return t;
	}
	
}