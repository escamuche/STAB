package com.stab.data.adventure;

import com.stab.adventure.Adventure;
import com.stab.data.utils.StabBlockData;
import com.stab.model.basic.scenes.Choice;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;

public class ColiseoAdventure extends Adventure{
	

	public ColiseoAdventure() {
		setName("Dos Zombies entran, uno sale!!!");
		setMinLevel(1);
		setMaxLevel(1);
		setMinPlayers(1);
		setMaxPlayers(5);
		setAuthor("TestAdventure");
		setDescription("Hagan sus apuestas!!!");
		setIcon("rats");
	}
	
	public void init(){
		super.init();
		clearScenes();
		
		Narration n=new Narration();
		n.createContents();
		n.setTag("BEGIN");
		n.setNext("BATTLE.Balconada");
		n.setText("Entra, no seas timido.");
		this.addScene(n);

		Choice c=new Choice();
		c.createContents();
		c.setTag("CHOICE");
		c.setText("Que pases, contra!");
		c.addOption("Pos vale, voy","BATTLE.Balconada");
		//c.addOption("Bajar por las escaleras de la izquierda","BATTLE.stairs2");
		c.addOption("Marcharse","VICTORY");
		this.addScene(c);
		
		DefaultTileMapScene ms=new DefaultTileMapScene();
		ms.createContents();
		ms.createMap(24,16);
		ms.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
		ms.loadTiled("coliseo", 0, 0);
		ms.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
		
		ms.setTag("BATTLE");
		
	//	DefaultRule r=new DefaultRule();
	//	r.setEvent(InfoDestroyed.class);
	//	r.addCondition(new InfoIsClass(Dummy.class));
	//	r.addResponse(new VictoryResponse(0,"VICTORY"));
	//	ms.addRule(r);
		this.addScene(ms);
		
		Narration n2=new Narration();
		n2.createContents();
		n2.setTag("VICTORY");
		n2.setText("Victoria!");
		n2.setNext(null);
		this.addScene(n2);
	}
	
}