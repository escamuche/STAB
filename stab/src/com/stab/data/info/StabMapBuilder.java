package com.stab.data.info;

import com.stab.model.basic.scenes.map.gen.BasicMapBuilder;
import com.stab.model.info.Info;
import com.stab.model.info.base.RandomSpawner;
import com.stab.pf.StabTables;
import com.stab.pf.info.monster.Monster;

public class StabMapBuilder extends BasicMapBuilder {

	
	public StabMapBuilder() {
	
		assign(TREASURE, StabTables.TREASURE);
		assign(THEMED_ENCOUNTER, StabTables.RND_LEVEL1);
		assign(LEVELED_ENCOUNTER, StabTables.RND_LEVEL1);
		assign(THEMED_ALTERNATE, StabTables.RND_LEVEL1);
	}
	
	
	
	
	@Override
	protected Info createInfo(String type) {
		Info i= super.createInfo(type);
		if (i instanceof RandomSpawner){
			i.setFaction(Monster.DEFAULT_MONSTER_FACTION); //A pelo, todos los bichos la misma faction
			
		}
		return i;
	}
	
}
