package com.stab.data.scene;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import com.stab.client.slick.BasicActionsController;
import com.stab.common.Constants;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Panel;

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
	}

	public int addTracker(QuestTracker qt){
		trackers.add(qt);
		questPanel.addChild(qt);
		return trackers.size()-1;
	}
	
	public QuestTracker getTracker(int number){
		try{
			return trackers.get(number);
		}catch(Exception e){}
		return null;
	}
	
}
