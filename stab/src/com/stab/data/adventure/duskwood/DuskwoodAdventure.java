package com.stab.data.adventure.duskwood;

import com.stab.adventure.Adventure;
import com.stab.common.events.DefaultRule;
import com.stab.data.StabTables;
import com.stab.data.info.monster.Undead;
import com.stab.data.info.monster.bestiary.PlagueZombie;
import com.stab.data.info.monster.bestiary.Zombie;
import com.stab.data.rules.TrackerSetStatusResponse;
import com.stab.data.scene.DefaultStabMapScene;
import com.stab.data.scene.QuestTracker;
import com.stab.data.utils.StabBlockData;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.event.InfoDestroyed;
import com.stab.model.basic.scenes.event.InfoEntersZone;
import com.stab.model.basic.scenes.event.InfoEvent;
import com.stab.model.basic.scenes.event.condition.InfoIsFaction;
import com.stab.model.basic.scenes.event.condition.InfoIsPlayer;
import com.stab.model.basic.scenes.event.condition.InfoIsTag;
import com.stab.model.basic.scenes.event.response.ActivateRuleResponse;
import com.stab.model.basic.scenes.event.response.DefeatResponse;
import com.stab.model.basic.scenes.event.response.ShowMessageResponse;
import com.stab.model.basic.scenes.event.response.infos.AddTraitResponse;
import com.stab.model.basic.scenes.event.response.infos.PlayAnimationResponse;
import com.stab.model.basic.scenes.event.response.infos.SetMusicResponse;
import com.stab.model.basic.scenes.event.response.infos.SpawnRandomInfoResponse;
import com.stab.model.basic.scenes.event.rule.AllPlayersDeadRule;
import com.stab.model.basic.scenes.event.rule.TurnsElapsedRule;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
import com.stab.model.info.trait.Trait;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.util.InfosWeightedTable;

public class DuskwoodAdventure extends Adventure {

	public static final String ZOMBIE="T_ZOMBIE";
	public static final String ZOMBIES="T_ZOMBIES";
	public static final String UNDEAD2="T_UNDEAD2";
	
	public DuskwoodAdventure() {
		setName("Duskwood");
		setMinLevel(1);
		setMaxLevel(1);
		setMinPlayers(1);
		//setMinPlayers(2);
		setMaxPlayers(5);
		setAuthor("TestAdventure");
		setDescription("Stranded in the woods, you found someone in need for help");
		setIcon("rats");
	
	}
	
	
	@Override
	public void init() {
		super.init();
		clearScenes();
		
	//Music: Abandoned , luego Pursued, si acaso, LastBattle en la ultima oleada
		
		Narration n=new Narration();
		n.createContents();
		n.setTag("BEGIN");
		n.setNext("MAP.START");
		n.setText("A huge storm had you looking for shelter in the forest of Duskwood. As the night nears, you found yourselves to be completely lost, and begin to wander. Suddenly, you find a clearing in the forest, with a ruined chapel just ahead.");
		this.addScene(n);
		
		
		DefaultStabMapScene ms=new DefaultStabMapScene();
		ms.createContents();
		ms.createMap(32,56);
		ms.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
		ms.loadTiled("abbey", 0, 0);
		ms.setTiles(DefaultTileMapScene.DEFAULT,"tiles2");
		ms.setTag("MAP");
		ms.setWaitsForAll(true);
		ms.setMusic("Abandoned");
		//Quests
		QuestTracker qt1=new QuestTracker();
		qt1.setMessage("Explore the ruined chapel");
		qt1.setState(QuestTracker.IN_PROGRESS);
		ms.addTracker(qt1);
		QuestTracker qt2=new QuestTracker();
		qt2.setMessage("Protect the holy relic");
		qt2.setState(QuestTracker.UNDISCOVERED);
		ms.addTracker(qt2);
		QuestTracker qt3=new QuestTracker();
		qt3.setMessage("Ensure Brother Manfred survives");
		qt3.setState(QuestTracker.UNDISCOVERED);
		qt3.setOptional(true);
		ms.addTracker(qt3);
		
		
		//Tablas de spawn
		InfosWeightedTable t= new InfosWeightedTable();
		t.setValues("1:"+Zombie.ID+","+Zombie.ID+";3:"+Zombie.ID+";1:"+PlagueZombie.ID);
		StabTables.registerTable(ZOMBIE, t);
		t= new InfosWeightedTable();
		t.setValues("2:TABLE#"+ZOMBIE+",TABLE#"+ZOMBIE+",TABLE#"+ZOMBIE+";1:TABLE#"+ZOMBIE+",TABLE#"+ZOMBIE+",TABLE#"+ZOMBIE+",TABLE#"+ZOMBIE);
		StabTables.registerTable(ZOMBIES, t);
		
		//Esta regla asigna un trait a cada undead que spawnea, haciendole que odie la reliquia, sepa donde esta y vaya a por ella
		DefaultRule rcreated = new DefaultRule();
		rcreated.setEvent(InfoEntersZone.class);
		rcreated.addCondition(new InfoIsFaction(Undead.DEFAULT_UNDEAD_FACTION));
		Trait tr=new AttackTargetTrait(ms.getElementByTag("RELIC"));
		rcreated.addResponse(new AddTraitResponse(tr));
		
		
		//wave spawn. un contador de un par de turnos desde que se pone en marcha, que lanza la primera oleada y activa otra regla
		DefaultRule wave1 = new TurnsElapsedRule(3);
		wave1.setOnlyOnce(true);
		wave1.setActive(false);
		wave1.addResponse(new SetMusicResponse("Pursued"));
		wave1.addResponse(new ShowMessageResponse(null, "You are alerted by an inhuman growl. Something foul has awakened and is coming towards the chapel"));
		wave1.addResponse(new SpawnRandomInfoResponse(ZOMBIES, "GRAVEYARD1"));
		wave1.addResponse(new SpawnRandomInfoResponse(ZOMBIES, "GRAVEYARD2"));
		//	wave1.addResponse(new ActivateRuleResponse(wave2))
		ms.addRule(wave1);
		
		//cambio de quest, dialogo y arranque del spawn cuando un jugador entra en la zona central de la capilla
		DefaultRule r1 = new DefaultRule();
		r1.setOnlyOnce(true);
		r1.setEvent(InfoEntersZone.class);
		r1.addCondition(new InfoIsPlayer());
		r1.addCondition(new InfoIsTag(InfoEvent.TARGET,"chapel"));
		r1.addResponse(new TrackerSetStatusResponse(0, QuestTracker.COMPLETED));
		r1.addResponse(new TrackerSetStatusResponse(1, QuestTracker.IN_PROGRESS));
		r1.addResponse(new TrackerSetStatusResponse(2, QuestTracker.IN_PROGRESS));
	
		r1.addResponse(new PlayAnimationResponse("MANFRED",VisualEffect.CENTER_CAM_ANIMATION));
		r1.addResponse(new PlayAnimationResponse("MANFRED",VisualEffect.SPEECH_ANIMATION,"Praised be Desna! My prayers have been heard! Quickly, gather around..."));
		r1.addResponse(new PlayAnimationResponse("MANFRED",VisualEffect.SPEECH_ANIMATION,"This is a holy relic. Its power is fragile, but it attracts the undead. I need your help protecting the relic, or this forest will be doomed forever!"));
		r1.addResponse(new PlayAnimationResponse("MANFRED",VisualEffect.SPEECH_ANIMATION,"There are things around the abbey that could help with the defense. Prepare yourselves, they will be here soon."));
		r1.addResponse(new ActivateRuleResponse(wave1));
		ms.addRule(r1);
		
		
		//rule para Manfred debe sobrevivir. solo marca la quest como fallida
		DefaultRule rmanfred = new DefaultRule();
		rmanfred.setEvent(InfoDestroyed.class);
		rmanfred.addCondition(new InfoIsTag("MANFRED"));
		rmanfred.addResponse(new TrackerSetStatusResponse(2, QuestTracker.FAILED));
		ms.addRule(rmanfred);
		
		//regla para la reliquia debe sobrevivir. Lleva a una escena de fracaso distinta de la normal
		DefaultRule rrelic = new DefaultRule();
		rrelic.setEvent(InfoDestroyed.class);
		rrelic.addCondition(new InfoIsTag("RELIC"));
		rrelic.addResponse(new TrackerSetStatusResponse(1, QuestTracker.FAILED));
		rrelic.addResponse(new DefeatResponse(0,"DEFEAT2"));
		ms.addRule(rrelic);
		
		
		//regla tipica de "todos los pjs han muerto"
		AllPlayersDeadRule r2=new AllPlayersDeadRule();
		r2.addResponse(new DefeatResponse(0,"DEFEAT"));
		ms.addRule(r2);
		
		
		this.addScene(ms);
		
		//Escenas finales
		Narration n2=new Narration();
		n2.createContents();
		n2.setTag("VICTORY");
		n2.setText("You have defeated all the enemies and protected the relic. Well done!");
		n2.setNext(null);
		this.addScene(n2);
		
		n2=new Narration();
		n2.createContents();
		n2.setTag("DEFEAT");
		n2.setText("As the last one of you fall dead, the undead rush for the relic. Darkness will prey upon Duskwood forever, and you know you´ll be one of them soon.");
		n2.setNext(null);
		this.addScene(n2);
		
		n2=new Narration();
		n2.createContents();
		n2.setTag("DEFEAT2");
		n2.setText("Even though you still hold on, some of the undeads managed to reach the relic and destroy it. The relic explodes in a burst of energy, and you are blinded. You can't see the undeads, but you feel their bites and grasps, and know you'll join their ranks soon...");
		n2.setNext(null);
		this.addScene(n2);
	}
	
}
