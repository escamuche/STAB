package com.stab.pf.actions.player.spells.lvl1.unfinished;

import java.awt.Point;

import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTarget;

public class RemoveFear extends SpellOnTarget{
	
	public static final String ID="REMOVEFEAR";

	
	
	public RemoveFear() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(CLOSE);
     
		setResource("actions/ability_shaman_watershield");
		setName("Remove Fear");
		setDescription("You instill courage in the subject, granting it a +4 morale bonus against fear effects for 10 minutes. If the subject is under the influence of a fear effect when receiving the spell, that effect is suppressed for the duration of the spell.");
		this.setEffectType(BUFF);
		this.setDuration(FIXED);
		this.setDescriptors(EffectDescriptor.EVOCATION);
	}
	
	
	@Override
	public int affect(Info origin, Info t, Point point, ActionRequest ar) {
		return super.affect(origin, t, point, ar);
	}
}
