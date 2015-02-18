package com.stab.data;

import com.stab.common.fw.Reference;
import com.stab.common.utils.WeightedTable;
import com.stab.data.info.monster.bestiary.DireRat;
import com.stab.data.info.monster.bestiary.EsqueletoArquero;
import com.stab.data.info.monster.bestiary.GiantBombardierBeetle;
import com.stab.data.info.monster.bestiary.GoblinAlchemist;
import com.stab.data.info.monster.bestiary.GoblinShaman;
import com.stab.data.info.monster.bestiary.GoblinWarrior;
import com.stab.data.info.monster.bestiary.Kobold;
import com.stab.data.info.monster.bestiary.Orc;
import com.stab.data.info.monster.bestiary.PlagueZombie;
import com.stab.data.info.monster.bestiary.Skeleton;
import com.stab.data.info.monster.bestiary.Wolf;
import com.stab.data.info.monster.bestiary.Zombie;
import com.stab.data.info.props.TreasureChest;
import com.stab.util.InfosWeightedTable;

public class StabTables extends Reference<WeightedTable>{

	
	
	public static final String RND_LEVEL1="RND_LEVEL1";
	
	
	public static final String RND_GOBLIN="RND_GOBLIN";
	public static final String RND_UNDEAD="RND_UNDEAD";
	public static final String RND_ZOMBIE="RND_ZOMBIE";


	public static final String TREASURE = "TREASURE";
	
	
	static StabTables tables;
	
	static{
		tables=new StabTables();
		tables.init();
	}
	
	
	
	
	
	public static WeightedTable getTable(String id) {
		return tables.getValue(id);
	}

	
	public static void registerTable(String id,InfosWeightedTable t){
		tables.register(id, t);
	}


	//public static final String RND_GOBLIN="1:NULL;2:"+Goblin.ID+";2:"+GoblinShaman.ID+";1:"+Goblin.ID+","+Goblin.ID+";1:"+Goblin.ID+","+GoblinShaman.ID+";";
	

	
	public void init() {
		
		InfosWeightedTable t = new InfosWeightedTable();
		/*	t.addValue(1, "NULL");
	
		t.addValue(2, GoblinWarrior.ID);
		t.addValue(2, GoblinShaman.ID);
		t.addValue(1, GoblinWarrior.ID,GoblinShaman.ID);
		t.addValue(1, GoblinWarrior.ID,GoblinWarrior.ID);
		t.addValue(1, GoblinWarrior.ID,GoblinWarrior.ID, GoblinWarrior.ID);
		t.addValue(1, GoblinWarrior.ID,GoblinWarrior.ID,GoblinShaman.ID);/**/
		t.addValue(1, GoblinWarrior.ID,GoblinAlchemist.ID);
		t.addValue(1, GoblinShaman.ID,GoblinAlchemist.ID,GoblinWarrior.ID);
		t.addValue(1, GoblinShaman.ID,GoblinAlchemist.ID,GoblinWarrior.ID,GoblinWarrior.ID);
		t.addValue(1, GoblinShaman.ID,GoblinAlchemist.ID,GoblinWarrior.ID,GoblinAlchemist.ID,GoblinAlchemist.ID);
		register(RND_GOBLIN,t);
		
		t = new InfosWeightedTable();
		t.addValue(1, "NULL");
	/**/
		t.addValue(2, Skeleton.ID);
		t.addValue(2, EsqueletoArquero.ID);
		t.addValue(2, RND_ZOMBIE);
		t.addValue(1, Skeleton.ID,Skeleton.ID);
		t.addValue(1, EsqueletoArquero.ID,EsqueletoArquero.ID);
		t.addValue(1, Skeleton.ID,Zombie.ID);/**/
		t.addValue(1, Zombie.ID,RND_ZOMBIE);/**/
		register(RND_UNDEAD,t);
		
		t = new InfosWeightedTable();
		t.addValue(4, Zombie.ID);
		t.addValue(1, PlagueZombie.ID);
		register(RND_ZOMBIE,t);
		
		//Random level 1
		t = new InfosWeightedTable();
		t.addValue(1, Skeleton.ID,Skeleton.ID,Skeleton.ID);
		t.addValue(1, Skeleton.ID,EsqueletoArquero.ID,EsqueletoArquero.ID);
		t.addValue(1, Skeleton.ID,EsqueletoArquero.ID,Zombie.ID,Zombie.ID);
		t.addValue(1, EsqueletoArquero.ID,RND_UNDEAD);
		t.addValue(1, RND_ZOMBIE,RND_ZOMBIE,RND_ZOMBIE);
		
		t.addValue(4,RND_GOBLIN,GoblinShaman.ID);
		t.addValue(1,RND_GOBLIN,GoblinWarrior.ID);
		
		t.addValue(2, Kobold.ID,Kobold.ID,Kobold.ID,Kobold.ID,Kobold.ID);
		t.addValue(1, Kobold.ID,Kobold.ID,Kobold.ID,Kobold.ID,Kobold.ID,Kobold.ID);
		t.addValue(1, Kobold.ID,Kobold.ID,Kobold.ID,Kobold.ID,DireRat.ID,DireRat.ID);
		t.addValue(1, Kobold.ID,DireRat.ID,DireRat.ID);
		
		
		t.addValue(1, DireRat.ID,DireRat.ID,DireRat.ID,DireRat.ID);
		t.addValue(1, DireRat.ID,DireRat.ID,DireRat.ID,DireRat.ID,DireRat.ID);
		
		t.addValue(1, GiantBombardierBeetle.ID,GiantBombardierBeetle.ID,GiantBombardierBeetle.ID);
		
		t.addValue(2, Orc.ID,Orc.ID);
		t.addValue(1, Orc.ID,GoblinWarrior.ID,GoblinWarrior.ID);
		t.addValue(1, Orc.ID,Wolf.ID,Wolf.ID);
	
		register(RND_LEVEL1,t);
		
		
		t = new InfosWeightedTable();
		t.addValue(1, TreasureChest.ID);
		register(TREASURE,t);
		
	}
	
	
	
}
