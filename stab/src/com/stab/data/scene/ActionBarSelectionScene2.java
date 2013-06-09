package com.stab.data.scene;

import com.stab.common.Constants;
import com.stab.model.Player;
import com.stab.model.action.Action;
import com.stab.model.action.ActionSet;
import com.stab.model.action.base.BasicAction;
import com.stab.model.basic.scenes.InfoDataScene;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Image;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Panel;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.tien.princess.engine.sprite.ui.Text;

public class ActionBarSelectionScene2 extends InfoDataScene{
	
	
	public static final String ID="ACTIONS_SCENE";
	

	Panel actionBook;
	
	public void createContents() {
		super.createContents();
		setBackground("ui/scroll$S");
		setMusic(null);
		setMargin(60,70);
		setGap(5,15);
		
		
		actionBook=new Panel();
		actionBook.setPos(Constants.BEGIN,Constants.NEXT);
		actionBook.setSize(Constants.PERCENT+40,Constants.PERCENT+70);
		actionBook.setBackground("ui/bookleft$S");
		actionBook.setMargin(60);

		
		addGUI(actionBook);
		
		
		
		Button finish=new Button();
		finish.setText("Continuar");
		finish.setImage("ui/point");
		finish.setMode(Label.LABEL);  
		finish.setAction("CONTINUAR");
		finish.setPos(Constants.MIDDLE,Constants.END); 
		finish.setSize(Constants.PERCENT+50,Constants.CONTENT); 
		addGUI(finish);
		
		doLayout();
	}
	
	@Override
	public void playerOption(Player player, String option) {
		
		
		
		if ("CONTINUAR".equals(option))
			travelToScene(player,null);
		
		
		
	}
	
	public void createActions(Panel p){
		ActionSet as=((BaseInfo)getInfo()).getActionSet();
		for (Action a:as.getAllActions())
			if (isValidAction(p,a)){
				createAction(p,a);
			}
	}
	
	protected void createAction(Panel p, Action a) {
		Image di=new Image();
		di.setSize(64, 64);
		di.setImage(a.getResource((BaseInfo)getInfo()));
	//	di.setIcon(a.getResource((BaseInfo)getInfo()));
		di.setTooltip(a.getDescription());
		di.setPos(Constants.PREVIOUS,Constants.NEXT_MAX);
		p.addChild(di);
		Text text=new Text();
		text.setText(a.getName());
		text.setSize(192,64);
		text.setPos(Constants.NEXT,Constants.PREVIOUS);
		p.addChild(di);
		//System.out.println("+"+di+" "+a);
	}


	protected boolean isValidAction(Panel p, Action a) {
		if (a instanceof BasicAction)
			return false;
		return true;
	}


	@Override
	protected void refreshInfo(Info i) {
		super.refreshInfo(i);
		createActions(actionBook);
	
	}
	
}
