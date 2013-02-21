package com.stab.data.adventure;

import com.stab.adventure.Adventure;
import com.stab.data.utils.DefaultBlockData;
import com.stab.model.basic.scenes.Choice;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
import com.stab.model.basic.scenes.map.TileMapScene;

public class TestAdventure extends Adventure{
	

	public TestAdventure() {
		setName("Rats in the cellar");
		setMinLevel(1);
		setMaxLevel(1);
		setMinPlayers(1);
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
		n.setText("Mientras estais celebrando el resultado de vuestra �ltima aventura en la taberna, una anciana se os acerca con la mirada perdida. Cuando os pregunta si sois aventureros, el alcohol os juega una mala pasada y contestais que s�. Ilusionada, os comenta que tiene un problema en su s�tano y que necesita de vuestra ayuda para resolverlo. Su mirada es tan lastimosa que no podeis evitar el ofreceros para ayudarla.");
		this.addScene(n);

		Choice c=new Choice();
		c.createContents();
		c.setTag("CHOICE");
		c.setText("Acompa�ais a la anciana hasta su casa en las afueras. Aparentemente, tiene una plaga de ratas en su s�tano, y os pagar� generosamente si acabais con ellas, siempre y cuando ninguna consiga escapar. El s�tano tiene dos accesos, uno por las escaleras de la casa y otro por una trampilla en el exterior. Seria recomendable dividirse para evitar que escapen.");
		c.addOption("Bajar por las escaleras de la casa","BATTLE.stairs");
		c.addOption("Acceder desde la trampilla exterior","BATTLE.cellar");
		this.addScene(c);
		
		TileMapScene ms=new DefaultTileMapScene();
		ms.createContents();
		ms.loadTiled("map2", 0, 0);
		ms.setTiles(DefaultTileMapScene.DEFAULT,"newtiles");
		ms.setProperties(DefaultTileMapScene.DEFAULT, DefaultBlockData.ID);
		ms.setTag("BATTLE");
		this.addScene(ms);
	}
	
}