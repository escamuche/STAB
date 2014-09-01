package com.stab.data.actions.player.spells.lvl1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.actions.player.spells.lvl1.effects.Shield_Buff;
import com.stab.model.action.BuffDebuffAction;
import com.stab.model.info.BaseInfo;

public class Shield extends SpellOnSelf implements BuffDebuffAction{
	
	public static final String ID="Shield";
	
	public Shield() {
     setResource("actions/shield");
     setName("Shield");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.WIZARDCASTER);
     this.setDescription("Shield creates an invisible shield of force that hovers in front of you. It negates magic missile attacks directed at you. The disk also provides a +4 shield bonus to AC. This bonus applies against incorporeal touch attacks, since it is a force effect. The shield has no armor check penalty or arcane spell failure chance.");
     setDuration(MEDIUM);
     setDescriptors(EffectDescriptor.ABJURATION,EffectDescriptor.FORCE);
	 this.setLevel(1);
	 setTraitIDActivated(Shield_Buff.ID);
	}

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		Shield_Buff buff = new Shield_Buff(getSpell(),caster);
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}

	
	public int getEffectValue(BaseInfo i, com.stab.model.info.Info target) {
		
		return 4*4;
	}

	@Override
	public String getEffectId() {
		return Shield_Buff.ID;
	}

	@Override
	public int getMaxStack() {
		return 1;
	}

	@Override
	public boolean concentrateStack() {
		return false;
	};
	
}