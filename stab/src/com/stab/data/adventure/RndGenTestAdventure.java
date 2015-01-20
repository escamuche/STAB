package com.stab.data.adventure;

import com.stab.adventure.Adventure;
import com.stab.data.scene.DefaultStabMapScene;
import com.stab.data.utils.StabBlockData;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
import com.stab.model.basic.scenes.map.gen.BasicMapBuilder;

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
		ms.setTag("BATTLE");
		ms.createContents();
		ms.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
		ms.setTiles(DefaultTileMapScene.DEFAULT,"tiles2");
	
		BasicMapBuilder builder=new BasicMapBuilder();
		builder.setScene(ms);  //Aqui ya tenemos que tener creado el mapa, y con los tileproperties listos (nos lo han pasado en la aventura)
		builder.createMap(8, 8);
		builder.loadParts();     //porque aqui se necesita
		builder.generateMap();
		
		ms.setAllExplored(true);
		
		this.addScene(ms);
		
	
	}
}
