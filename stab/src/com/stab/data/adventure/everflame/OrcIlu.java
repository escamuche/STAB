package com.stab.data.adventure.everflame;

import com.stab.pf.info.monster.bestiary.Orc;

public class OrcIlu extends Orc {

	public static final String ID="ORCILU_INFO";
	
	@Override
	public void init() {
		super.init();
		Illusion_Buff ilu = new Illusion_Buff();
		this.addTrait(ilu);
		
	}
	
}
