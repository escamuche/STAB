package com.stab.data;

import com.stab.common.fw.Reference;
import com.stab.common.utils.WeightedTable;
import com.stab.data.info.monster.bestiary.Goblin;
import com.stab.data.info.monster.bestiary.GoblinShaman;
import com.stab.util.InfosWeightedTable;

public class StabTables extends Reference<WeightedTable>{

	
	public static final String RND_GOBLIN="RND_GOBLIN";
	
	
	static StabTables tables;
	
	static{
		tables=new StabTables();
		tables.init();
	}
	
	
	
	
	
	public static WeightedTable getTable(String id) {
		return tables.getValue(id);
	}



	//public static final String RND_GOBLIN="1:NULL;2:"+Goblin.ID+";2:"+GoblinShaman.ID+";1:"+Goblin.ID+","+Goblin.ID+";1:"+Goblin.ID+","+GoblinShaman.ID+";";
	

	
	public void init() {
		
		InfosWeightedTable t = new InfosWeightedTable();
		t.addValue(1, "NULL");
		t.addValue(2, Goblin.ID);
		t.addValue(2, GoblinShaman.ID);
		t.addValue(1, Goblin.ID,GoblinShaman.ID);
		t.addValue(1, Goblin.ID,Goblin.ID);
		register(RND_GOBLIN,t);
		
	}
	
}
