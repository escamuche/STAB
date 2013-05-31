package com.stab.data.actions.player.spells.cleric.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.Torchlight_Buff;
import com.stab.model.info.BaseInfo;

public class Light extends SpellOnTarget{
	
	public static final String ID="LIGHT_CLERIC";
	boolean u = false;
	BaseInfo t = null;
	Torchlight_Buff buff = new Torchlight_Buff();
	
	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		if(u==false){
		u=true;
		t=target;
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
		}
		else{
			t.removeTrait(buff);
			target.addTrait(buff);
			return super.fullEffect(caster, target, point);
		}
	}
	
	public Light() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(1);
		setResource("actions/light");
		setName("Light");
		this.setEffectType(BUFF);
	}
}
