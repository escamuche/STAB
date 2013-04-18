package com.stab.data.info.monster.bestiary;

import com.stab.data.info.buff.Illusion_Buff;

public class OrcIlu extends Orc {

	public static final String ID="ORCILU_INFO";
	
	@Override
	public void init() {
		super.init();
		Illusion_Buff ilu = new Illusion_Buff();
		this.addTrait(ilu);
		
	}
	
}
