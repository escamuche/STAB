package com.stab.data.info.ui;

import com.stab.client.slick.BasicActionsController;
import com.stab.common.Constants;
import com.stab.model.action.Action;
import com.stab.model.action.ActionSet;
import com.stab.model.action.base.BasicAction;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Panel;
import com.stab.model.basic.ui.Text;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.interfaces.PlayerOwned;


public class ActionPanel extends Panel{

	BaseInfo info;
	
	Panel act1;
	
	@Override
	public void init() {
		super.init();
	
		setOpenAction(BasicActionsController.SKILLBOOK);
		setSize(480,512);
		setPos(Constants.BEGIN,60);
		setBackground("ui/paperback$S");
		setOverlay("ui/consolefront$X");
		Text t= new Text();
		t.setText("Actions");
		t.setPos(Constants.CENTER,Constants.BEGIN);
		t.setSize(Constants.FILL,Constants.CONTENT);
		addChild(t);
		act1= new Panel();
		act1.setSize(Constants.FILL,400);
		act1.setPos(Constants.BEGIN,Constants.NEXT);
		//act1.setBackground("ui/consoleback$X");
		act1.setMargin(3);
		
		addChild(act1);
	}
	
	public void setInfo(BaseInfo info) {
		this.info = info;
		this.setPlayerRestricted(((PlayerOwned)info).getOwner());
		refresh();

	}
	
	public BaseInfo getInfo() {
		return info;
	}
	
	public void refresh(){
		createActions(act1);
	}
	
	
	
	public void createActions(Panel p){
		ActionSet as=((BaseInfo)getInfo()).getActionSet();
		for (Action a:as.getAllActions())
			if (isValidAction(p,a)){
				createAction(p,a);
			}
	}
	
	

	protected void createAction(Panel p,Action a) {
		Button di=new Button();
		di.setButtonType(Button.RADIO);
		di.setButtonGroup("ACTBG"+info.getId());
		//di.setBackground("ui/actionoverlays#0");
		di.setSize(40, 40);
		di.setImage("FOUR#red#"+a.getResource((BaseInfo)getInfo())+"$S");
		di.setTooltip(a.getName()+"#"+a.getDescription());
		di.setPos(Constants.NEXT,Constants.PREVIOUS);
		
		p.addChild(di);
		
		//System.out.println("+"+di+" "+a);
	}


	protected boolean isValidAction(Panel p, Action a) {
		if (a instanceof BasicAction)
			return false;
		return true;
	}
}
