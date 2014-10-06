package com.stab.data.scene;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import com.stab.client.slick.BasicActionsController;
import com.stab.common.Constants;
import com.stab.data.info.player.PathfinderCharacter;
import com.stab.data.ui.ActionPanel;
import com.stab.data.ui.CharSheetPanel;
import com.stab.data.ui.PlayerInventoryPanel;
import com.stab.data.ui.QuestTracker;
import com.stab.model.basic.scenes.event.response.DefeatResponse;
import com.stab.model.basic.scenes.event.response.VictoryResponse;
import com.stab.model.basic.scenes.event.rule.AllPlayersAtZoneRule;
import com.stab.model.basic.scenes.event.rule.AllPlayersDeadRule;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Panel;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.interfaces.PlayerOwned;

public class DefaultStabMapScene  extends DefaultTileMapScene {

	Panel questPanel;
	ArrayList<QuestTracker> trackers;
	
	
	
	@Override
	public void init() {
		trackers=new ArrayList<QuestTracker>();
		super.init();
	}
	
	@Override
	public void createContents(){
		super.createContents();
		createQuestPanel();
	}
	
	public void createQuestPanel() {
		questPanel= new Panel();
		questPanel.setOpenAction(BasicActionsController.QUEST_LOG);
		questPanel.setSize(240,Constants.CONTENT);
		questPanel.setPos(Constants.END,Constants.CENTER);
		questPanel.setBackground("ui/consoleback$X");
		questPanel.setOverlay("ui/consolefront$X");
		Label lbl= new Label();
		lbl.setColor(Color.white);
		lbl.setPos(Constants.BEGIN,Constants.BEGIN);
		lbl.setText("Objectives");
		questPanel.addChild(lbl);
		this.add(questPanel);
		questPanel.setVisible(false);
	}

	public int addTracker(QuestTracker qt){
		trackers.add(qt);
		questPanel.addChild(qt);
		questPanel.setVisible(true);
		return trackers.size()-1;
	}
	
	public QuestTracker getTracker(int number){
		try{
			return trackers.get(number);
		}catch(Exception e){}
		return null;
	}
	
	
	
	@Override
	public void addInfo(Info info) {
		super.addInfo(info);
		if (info instanceof PathfinderCharacter)
			if (info instanceof PlayerOwned){
				CharSheetPanel cp= new CharSheetPanel();
				cp.setInfo((BaseInfo)info);
				add(cp);
				cp.setVisible(false);
				ActionPanel ap= new ActionPanel();
				ap.setInfo((BaseInfo)info);
				add(ap);
				ap.setVisible(false);
				PlayerInventoryPanel ip= new PlayerInventoryPanel();
				ip.setInfo((BaseInfo)info);
				add(ip);
				ip.setVisible(false);
			}
	}
	
	
	public void setOnDeath(String nextScene){
		AllPlayersDeadRule r=new AllPlayersDeadRule();
		r.addResponse(new DefeatResponse(0,nextScene));
		addRule(r);
	}
	public void setOnExit(String exit,String nextScene){
		AllPlayersAtZoneRule r=new AllPlayersAtZoneRule(exit);
		r.addResponse(new VictoryResponse(0,nextScene));
		addRule(r);
	}
	
	
}
