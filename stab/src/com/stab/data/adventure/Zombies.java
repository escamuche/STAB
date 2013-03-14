package com.stab.data.adventure;

import com.stab.adventure.Adventure;
import com.stab.common.events.DefaultRule;
import com.stab.data.info.props.Dummy;
import com.stab.data.utils.DefaultBlockData;
import com.stab.model.basic.scenes.Choice;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.event.InfoDestroyed;
import com.stab.model.basic.scenes.event.condition.InfoIsClass;
import com.stab.model.basic.scenes.event.response.VictoryResponse;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
import com.stab.model.basic.scenes.map.TileMapScene;

public class Zombies extends Adventure{
	

	public Zombies() {
		setName("The Walking (HURRA!) Deads");
		setMinLevel(1);
		setMaxLevel(1);
		setMinPlayers(1);
		setMaxPlayers(5);
		setAuthor("TestAdventure");
		setDescription("Killing the zombie, killing, killing, killing the zombie");
		setIcon("rats");
	}
	
	public void init(){
		super.init();
		clearScenes();
		
		Narration n=new Narration();
		n.createContents();
		n.setTag("BEGIN");
		n.setNext("CHOICE");
		n.setText("El gran Khan surge de su tienda y os mira con mirada penetrante. Os ha convocado a su presencia por algun motivo desconocido para vosotros y tras estudiaros largamente habla con voz rotunda y grave: ");
		this.addScene(n);

		Choice c=new Choice();
		c.createContents();
		c.setTag("CHOICE");
		c.setText("Jovenes guerreros, una vez una persona sabia dijo que todo aventurero empezo su carrera con una espada flacida y un zombie estatico. Espadas teneis, y debeis dejar a todos los zombies estaticos, asi demostrareis vuestra valia como adultos y lo que es mejor, mis guerreros podran hacer apuestas. No remoloneeis y bajar por una de las escaleras a vuestro destino.");
		c.addOption("Bajar por las escaleras de la derecha","BATTLE.stairs");
		c.addOption("Bajar por las escaleras de la izquierda","BATTLE.stairs2");
		//c.addOption("Marcharse","VICTORY");
		this.addScene(c);
		
		DefaultTileMapScene ms=new DefaultTileMapScene();
		ms.createContents();
		ms.createMap(24,16);
		ms.loadTiled("zombies", 0, 0);
		ms.setTiles(DefaultTileMapScene.DEFAULT,"newtiles");
		ms.setProperties(DefaultTileMapScene.DEFAULT, DefaultBlockData.ID);
		ms.setTag("BATTLE");
		
		DefaultRule r=new DefaultRule();
		r.setEvent(InfoDestroyed.class);
		r.addCondition(new InfoIsClass(Dummy.class));
		r.addResponse(new VictoryResponse(0,"VICTORY"));
		ms.addRule(r);
		this.addScene(ms);
		
		Narration n2=new Narration();
		n2.createContents();
		n2.setTag("VICTORY");
		n2.setText("Victoria! Todos los zombies han sido estatizados y montones de guerreros han perdido su dinero por no confiar en vosotros!!!");
		n2.setNext(null);
		this.addScene(n2);
	}
	
}