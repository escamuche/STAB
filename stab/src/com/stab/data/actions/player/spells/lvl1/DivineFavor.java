package com.stab.data.actions.player.spells.lvl1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.actions.player.spells.lvl1.effects.DivineFavor_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DivineFavor extends SpellOnSelf{
	
	public static final String ID="DIVINEFAVOR";
	
	public DivineFavor() {
     setResource("actions/divinefavor");
     setName("Divine Favor");
     this.setEffectType(BUFF);
     this.setCasterClass(StabConstants.CLERICCASTER);
     this.setDescription("Calling upon the strength and wisdom of a deity, you gain a +1 luck bonus on attack and weapon damage rolls for every three caster levels you have (at least +1, maximum +3). The bonus doesn't apply to spell damage.");
     this.setLevel(1);
     this.setDuration(FIXED);
     this.setDescriptors(EffectDescriptor.EVOCATION);
     this.setTraitIDActivated(DivineFavor_Buff.ID);
	}

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	int cl =getCasterLevel(caster);
	
	DivineFavor_Buff buff = new DivineFavor_Buff(getSpell(),caster);
	target.addTrait(buff);
	return super.fullEffect(caster, target, point);
}


@Override
public int getEffectValue(BaseInfo i, Info target) {
	return 3;
}

}