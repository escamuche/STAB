package com.stab.pf.actions.player.spells.lvl0.effects;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.pf.actions.player.spells.Spell;
import com.stab.pf.info.spellcasting.SpellEffect;

public class Light_Buff extends  SpellEffect{

	public Light_Buff(Spell spell, Info caster) {
		super(spell, caster);
		this.addTrait(new Light_Effect());
	}

	
	LightInUse inUseTrait = null;
	
	public LightInUse getInUseTrait() {
		return inUseTrait;
	}
	
	public void setInUseTrait(LightInUse inUseTrait) {
		this.inUseTrait = inUseTrait;
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		if(inUseTrait!=null){
			inUseTrait=null;
		}
		super.removeFrom(baseInfo);
	}
	
	
}
