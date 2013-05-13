package com.stab.data.adventure;

import com.stab.adventure.Adventure;
import com.stab.common.events.DefaultRule;
import com.stab.data.StabConstants;
import com.stab.data.rules.CharacterSkillRollCondition;
import com.stab.data.utils.StabBlockData;
import com.stab.model.basic.scenes.Choice;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.event.PlayerEntersScene;
import com.stab.model.basic.scenes.event.response.DefeatResponse;
import com.stab.model.basic.scenes.event.response.ShowMessageResponse;
import com.stab.model.basic.scenes.event.response.VictoryResponse;
import com.stab.model.basic.scenes.event.rule.AllMonstersDeadRule;
import com.stab.model.basic.scenes.event.rule.AllPlayersDeadRule;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
import com.stab.model.basic.ui.Text;


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
	/*
		Widget tp= new Widget();
		tp.setPos(Constants.CENTER,Constants.BEGIN);
		tp.setSize(Constants.PERCENT+50,Constants.PERCENT+30);
		//tp.setSize(600,200);
		tp.setBackground("SHADER#infernal");
		tp.setOverlay("ui/consolefront$B");
		
		Image i=n.createImage("tokens/direrat$S");
		i.setPos(-50,-50);
		
		i.setSize(140, 140);
	//	i.setImage("SHADER#infernal");
	//	n.addGUI(i);
		
		tp.addChild(i);
		Button bb= n.createButton("Test", "nothing to do");
		tp.addChild(bb);
		/**/
		
	/*	MessageWidget tp= new MessageWidget();
		tp.setImage("tokens/direrat");
		tp.setText("Este es un texto de prueba, ya veremos por donde corta"); 
		tp.setBackground("ui/consoleback$B");
		n.addGUI(tp);
		/**/
		n.setText("El gran Khan surge de su tienda y os mira con mirada penetrante. Os ha convocado a su presencia por algun motivo desconocido para vosotros y tras estudiaros largamente habla con voz rotunda y grave: ");
		Text tt=n.createText("Intuis que algo no va bien");
		tt.setVisible(false);
		n.addGUI(tt);
		
		DefaultRule rr= new DefaultRule();
		rr.setEvent(PlayerEntersScene.class);
		rr.addCondition(new CharacterSkillRollCondition(StabConstants.SENSEMOTIVE, 2));
		//rr.addResponse(new SetVisibleResponse(tt, true));
		rr.addResponse(new ShowMessageResponse(null, "Intuis que algo no va bien"));
		n.addRule(rr);
		this.addScene(n);

		Choice c=new Choice();
		c.createContents();
		c.setTag("CHOICE");
		c.setText("Jovenes guerreros, una vez una persona sabia dijo que todo aventurero empezo su carrera con una espada flacida y un zombie estatico. Espadas teneis, y debeis dejar a todos los zombies estaticos, asi demostrareis vuestra valia como adultos y lo que es mejor, mis guerreros podran hacer apuestas. No remoloneeis y bajar por una de las escaleras a vuestro destino.");
	//	c.addOption("Bajar por las escaleras de la derecha","BATTLE.stairs");
	//	c.addOption("Bajar por las escaleras de la izquierda","BATTLE.stairs2");
		c.addOption("Bajar por las escaleras","BATTLE.Entrance");
		//c.addOption("Marcharse","VICTORY");
		this.addScene(c);
		
		DefaultTileMapScene ms=new DefaultTileMapScene();
		ms.createContents();
		//ms.createMap(24,16);
		//ms.loadTiled("zombies", 0, 0);
		//ms.setTiles(DefaultTileMapScene.DEFAULT,"newtiles");
		//ms.setProperties(DefaultTileMapScene.DEFAULT, DefaultBlockData.ID);
		ms.createMap(64,64);
		ms.loadTiled("big", 0, 0);
		ms.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
		ms.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
		ms.setTag("BATTLE");
		
	//	DefaultRule r=new DefaultRule();
	//	r.setEvent(InfoDestroyed.class);
	//	r.addCondition(new InfoIsClass(Dummy.class));
		AllMonstersDeadRule r=new AllMonstersDeadRule();
		r.addResponse(new VictoryResponse(0,"VICTORY"));
		ms.addRule(r);
		AllPlayersDeadRule r2=new AllPlayersDeadRule();
		r2.addResponse(new DefeatResponse(0,"DEFEAT"));
		ms.addRule(r2);
		this.addScene(ms);
		
		Narration n2=new Narration();
		n2.createContents();
		n2.setTag("VICTORY");
		n2.setText("Victoria! Todos los zombies han sido estatizados y montones de guerreros han perdido su dinero por no confiar en vosotros!!!");
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