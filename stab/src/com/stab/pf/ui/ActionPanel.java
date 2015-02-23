package com.stab.pf.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.stab.client.slick.BasicActionsController;
import com.stab.common.Constants;
import com.stab.model.Player;
import com.stab.model.action.Action;
import com.stab.model.action.ActionSet;
import com.stab.model.action.base.BasicAction;
import com.stab.model.action.base.EmptyAction;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Panel;
import com.stab.model.basic.ui.advanced.ButtonPanel;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.interfaces.PlayerOwned;


public class ActionPanel extends ButtonPanel{

	BaseInfo info;
	
	Panel pact;
	ArrayList<Button> abuttons;
	
	
	@Override
	public void init() {
		super.init();
		setOpenAction(BasicActionsController.SKILLBOOK);
		setSize(480,512);
		setPos(Constants.BEGIN,60);
		getTitle().setText("Actions");
		pact= new Panel();
		pact.setSize(Constants.FILL,105);
		pact.setPos(Constants.BEGIN,400);
		pact.setMargins(5,5);
		pact.setGap(1, 5);
		pact.setLayout("default");
		pact.setOverlay("ui/nanoborder$X");
		addChild(pact);
		abuttons= new ArrayList<Button>();
		createButtons();
	}
	
	
	
	protected void createButtons() {
		for (int f=0;f<20;f++){
			Button b= new Button();
			b.setSize(45, 45);
			b.setPos(Constants.NEXT,Constants.PREVIOUS);
			if (f==10)
				b.setPos(Constants.BEGIN,Constants.NEXT_MAX);
			b.addButtonListener(this);
			b.setAction("ACTION"+f);
			b.setBackground("ui/actionoverlays&0$S");
			b.setOverlay("ui/actionoverlays&0$S");
			b.setMargin(2);
			b.setActOnScene(false);
			pact.addChild(b);
			abuttons.add(b);
		}
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
		ActionSet as=((BaseInfo)getInfo()).getActionSet();
		ArrayList<Action> list= new ArrayList<Action>(); 
		for (Action a:as.getAllActions())
			if (isValidAction(a)){
				list.add(a);
			}
		Collections.sort(list,new MyActionComparator());
		refresh(list);
	/*	*/
		for (int f=0;f<20;f++){
			Action a=as.getAction(f);
			if (a==null || a.getId()==EmptyAction.ID){
				abuttons.get(f).setImage(null);
			}else
				abuttons.get(f).setImage(a.getCanonicalResource()+"$S");
		}
		
	/**/	
	}
	
	
	
	

	
	@Override
	protected Button createButtonFor(Object o) {
		Button b=super.createButtonFor(o);
		Action a= (Action)o;
		b.setBackground("ui/actionoverlays&0$S");
		b.setMode(Label.BANNER);
		b.setMargin(2);
		b.setImage("FOUR#cyan#"+a.getResource()+"$S");
		b.setTooltip(a.getName()+"#"+a.getDescription());
		return b;
	}
	


	protected boolean isValidAction(Action a) {
		if (a instanceof BasicAction)
			return false;
		return true;
	}
	
	
	
	@Override
	public void buttonActivated(Player p, Button b) {
		if (b.getAction()!=null)
			if (b.getAction().startsWith("ACTION")){
				int n=Integer.parseInt(b.getAction().substring(6));
				if (getSelected() instanceof Action){
					ActionSet as=((BaseInfo)getInfo()).getActionSet();
					as.setAction((Action)getSelected(), n);
					b.setImage(((Action)getSelected()).getCanonicalResource()+"$S");
					((BaseInfo)getInfo()).reCheckActions();
				}
				return;
			}
		super.buttonActivated(p, b);
	}
}
class MyActionComparator implements Comparator<Action>{

	@Override
	public int compare(Action arg0, Action arg1) {
		String s="";
		String s2="";
		if (arg0.getName()!=null)
			s=arg0.getName();
		if (arg1.getName()!=null)
			s2=arg1.getName();
		return s.compareTo(s2);
	}
	
}
