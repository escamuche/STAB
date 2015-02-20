package com.stab.data.adventure;

import com.stab.adventure.Adventure;
import com.stab.data.info.StabMapBuilder;
import com.stab.data.scene.DefaultStabMapScene;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.event.rule.ConditionalMusic;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
import com.stab.model.basic.scenes.map.gen.BasicMapBuilder;
import com.stab.pf.utils.StabBlockData;

public class RndGenTestAdventure extends Adventure{
	

	public RndGenTestAdventure() {
		setName("RND");
		setMinLevel(1);
		setMaxLevel(1);
		setMinPlayers(1);
		setMaxPlayers(5);
		setAuthor("TestAdventure");
		setDescription("Test generacion Aleatoria");
		setIcon("rats");
	}
	
	public void init(){
		super.init();
		clearScenes();
		
		Narration n=new Narration();
		n.createContents();
		n.setTag("BEGIN");
		n.setNext("BATTLE.START");
		n.setText("Generar mapa.");
		this.addScene(n);
		
		DefaultStabMapScene ms=new DefaultStabMapScene();
		//RNDTestScene ms= new RNDTestScene();
		ms.setTag("BATTLE");
		ms.createContents();
		ms.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
		ms.setTiles(DefaultTileMapScene.DEFAULT,"tiles2");
	
		BasicMapBuilder builder=new StabMapBuilder();
		builder.setScene(ms);  //Aqui ya tenemos que tener creado el mapa, y con los tileproperties listos (nos lo han pasado en la aventura)
		builder.createMap(8, 8);
	
		builder.loadParts();     //porque aqui se necesita
		builder.generateMap();
	/*	
		ms.setBuilder(builder);
		builder.prepareMap();
		builder.placeInfos();
	/**/	
	//	ms.setAllExplored(true);
	//	ms.setAllVisible(true);
		
		
		ms.setWaitsForAll(true);
		ConditionalMusic m=new ConditionalMusic(ms);
		m.setMusic("Lone", "Pursued", "Midnight", "LastBattle");
		
		ms.setOnDeath("DEFEAT");
		
		this.addScene(ms);
		
		Narration n2=new Narration();
		n2.createContents();
		n2.setTag("VICTORY");
		n2.setText("Victoria! has escapado del dungeon!");
		n2.setNext(null);
		this.addScene(n2);
		
		n2=new Narration();
		n2.createContents();
		n2.setTag("DEFEAT");
		n2.setText("Todos los aventureros han muerto!");
		n2.setNext(null);
		this.addScene(n2);

	}
}
