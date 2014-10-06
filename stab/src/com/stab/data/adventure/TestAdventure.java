package com.stab.data.adventure;

import com.stab.adventure.Adventure;
import com.stab.data.scene.DefaultStabMapScene;
import com.stab.data.ui.QuestTracker;
import com.stab.data.utils.StabBlockData;
import com.stab.model.basic.scenes.Choice;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.event.response.DefeatResponse;
import com.stab.model.basic.scenes.event.response.VictoryResponse;
import com.stab.model.basic.scenes.event.rule.AllMonstersDeadRule;
import com.stab.model.basic.scenes.event.rule.AllPlayersDeadRule;
import com.stab.model.basic.scenes.event.rule.ConditionalMusic;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;

public class TestAdventure extends Adventure{
	

	public TestAdventure() {
		setName("Rats in the cellar");
		setMinLevel(1);
		setMaxLevel(1);
		setMinPlayers(1);
		//setMinPlayers(2);
		setMaxPlayers(5);
		setAuthor("TestAdventure");
		setDescription("A desperate woman needs help clearing her cellar of rats. Where else did you expect to begin?");
		setIcon("rats");
	}
	
	public void init(){
		super.init();
		clearScenes();
		
		Narration n=new Narration();
		n.createContents();
		n.setTag("BEGIN");
		n.setNext("CHOICE");
		n.setText("Mientras estais celebrando el resultado de vuestra última aventura en la taberna, una anciana se os acerca con la mirada perdida. Cuando os pregunta si sois aventureros, el alcohol os juega una mala pasada y contestais que sí. Ilusionada, os comenta que tiene un problema en su sótano y que necesita de vuestra ayuda para resolverlo. Su mirada es tan lastimosa que no podeis evitar el ofreceros para ayudarla.");
		this.addScene(n);

		Choice c=new Choice();
		c.createContents();
		c.setTag("CHOICE");
		c.setText("Acompañais a la anciana hasta su casa en las afueras. Aparentemente, tiene una plaga de ratas en su sótano, y os pagará generosamente si acabais con ellas, siempre y cuando ninguna consiga escapar. El sótano tiene dos accesos, uno por las escaleras de la casa y otro por una trampilla en el exterior. Seria recomendable dividirse para evitar que escapen.");
		c.addOption("Bajar por las escaleras de la casa","BATTLE.stairs");
		c.addOption("Acceder desde la trampilla exterior","BATTLE.cellar");
		//c.addOption("Marcharse","VICTORY");
		this.addScene(c);
		
		DefaultStabMapScene ms=new DefaultStabMapScene();
		ms.createContents();
		ms.createMap(24,16);
		ms.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
		ms.loadTiled("map2", 0, 0);
		ms.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
		//ms.setDefaultLightLevel(64);
		ms.setTag("BATTLE");
		ms.setWaitsForAll(true);
		
		QuestTracker qt=new QuestTracker();
		qt.setMessage("Kill all zombies");
		qt.setProgress(0);
		qt.setMax(1);
		qt.setState(QuestTracker.IN_PROGRESS);
		ms.addTracker(qt);
		
		ConditionalMusic m=new ConditionalMusic(ms);
		m.setMusic("Lone", "Pursued", "Midnight", "LastBattle");
		
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
		n2.setText("Victoria! todos los enemigos han sido eliminados!");
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
