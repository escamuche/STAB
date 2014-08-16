package com.stab.data.actions.player.spells.lvl0;

import java.awt.Point;

import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.actions.player.spells.lvl0.effects.DetectMagic_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;


public class DetectMagic extends SpellOnSelf{
	
	public static final String VISIONMODE="MAGIC";
	public static final String ID="DETECTMAGIC";

	public DetectMagic() {
	     
		 setLevel(0);
	     setResource("actions/spells/sheikah_eye");
	     setName("DetectMagic");
	     setDescription("Makes the caster able to see magical auras and effects, and allows trying to identify them.");
	     setEffectType(BUFF);
	     setDuration(MEDIUM);
	     setDescriptors(EffectDescriptor.DIVINATION);
	     this.setDismissable(true);
	}


	@Override
	public int affect(Info origin, Info t, Point point, ActionRequest ar) {
		
		DetectMagic_Buff b= new DetectMagic_Buff(getSpell(), origin);
		((BaseInfo)t).addTrait(b);
		return OK;
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 1;
	}
	
}