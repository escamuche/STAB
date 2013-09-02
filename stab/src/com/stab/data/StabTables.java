package com.stab.data;

import com.stab.common.fw.Reference;
import com.stab.common.utils.WeightedTable;
import com.stab.data.info.monster.bestiary.EsqueletoArquero;
import com.stab.data.info.monster.bestiary.Goblin;
import com.stab.data.info.monster.bestiary.GoblinShaman;
import com.stab.data.info.monster.bestiary.Skeleton;
import com.stab.data.info.monster.bestiary.Zombie;
import com.stab.util.InfosWeightedTable;

public class StabTables extends Reference<WeightedTable>{

	
	public static final String RND_GOBLIN="RND_GOBLIN";
	public static final String RND_UNDEAD="RND_UNDEAD";
	
	
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
	/**/
		t.addValue(2, Goblin.ID);
		t.addValue(2, GoblinShaman.ID);
		t.addValue(1, Goblin.ID,GoblinShaman.ID);
		t.addValue(1, Goblin.ID,Goblin.ID);/**/
		t.addValue(1, Goblin.ID,Goblin.ID, Goblin.ID);/**/
		t.addValue(1, Goblin.ID,Goblin.ID,GoblinShaman.ID);
		register(RND_GOBLIN,t);
		
		t = new InfosWeightedTable();
		t.addValue(1, "NULL");
	/**/
		t.addValue(2, Skeleton.ID);
		t.addValue(2, EsqueletoArquero.ID);
		t.addValue(2, Zombie.ID);
		t.addValue(1, Skeleton.ID,Skeleton.ID);
		t.addValue(1, EsqueletoArquero.ID,EsqueletoArquero.ID);
		t.addValue(1, Skeleton.ID,Zombie.ID);/**/
		t.addValue(1, Zombie.ID,Zombie.ID);/**/
		register(RND_UNDEAD,t);
		
	}
	
}
