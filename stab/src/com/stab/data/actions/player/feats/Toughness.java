package com.stab.data.actions.player.feats;

import com.stab.data.info.buff.Toughness_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Buff;

public class Toughness extends Buff{
	
	public static final String ID="TOUGHNESS";

	
	
	public Toughness() {
		
		BaseInfo caster = new BaseInfo();
		Toughness_Buff buff = new Toughness_Buff(caster);
		this.addTrait(buff);
		//this.setName("Improved Initiative");
		//this.setResource("actions/ability_warrior_safeguard");
		//this.setUsableByAI(false);
	
	}
		
}