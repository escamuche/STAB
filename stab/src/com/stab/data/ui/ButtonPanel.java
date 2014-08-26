package com.stab.data.ui;

import java.util.Collection;
import java.util.Hashtable;

import com.stab.client.slick.BasicActionsController;
import com.stab.common.Constants;
import com.stab.model.Player;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.ButtonListener;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Panel;

public class ButtonPanel extends Panel implements ButtonListener{

	Panel inner;
	Label title;
	Hashtable<Object,Button> map;
	Hashtable<Button,Object> map2;
	
	Object selected;
	
	
	@Override
	public void init() {
		super.init();
		selected=null;
		map=new Hashtable<Object,Button>();
		map2=new Hashtable<Button, Object>();
		setOpenAction(BasicActionsController.SKILLBOOK);
		setSize(480,512);
		setPos(Constants.BEGIN,60);
		setBackground("ui/paperback$S");
		setOverlay("ui/consolefront$X");
		setLayout("default");
		setMargins(8,8);
		setGap(8, 8);
		setMargin(5);
		title= new Label();
		title.setText(" ");
		title.setPos(Constants.CENTER,Constants.BEGIN);
		title.setSize(Constants.FULL,Constants.CONTENT);
		title.setMode(Label.BANNER);
	//	addChild(title);
		inner= new Panel();
		inner.setSize(Constants.FULL,Constants.CONTENT);
		inner.setPos(Constants.BEGIN,Constants.NEXT);
	//	inner.setPos(0,50);
	//	inner.setSize(445,350);
		inner.setMargins(8,8);
		inner.setGap(8, 8);
		inner.setLayout("rows");
		inner.setOverlay("ui/nanoborder$X");
		addChild(inner);
	}
	
	public Label getTitle() {
		return title;
	}
	public Panel getInnerPanel(){
		return inner;
	}
	
	
	public void refresh(Collection list){
		int n=0;
		//añadir los inexistentes
		for (Object o:list){
			if (map.get(o)==null){
				//crearlo
				Button b=createButtonFor(o);
				b.setOrder(n);
				map.put(o, b);
				map2.put(b, o);
			}else{
				//reconfigurarlo
				Button b=map.get(o);
				configureButton(b,o);
				b.setOrder(n);
			}
			n++;
		}
		//Purgar el resto
		for (Object o: map.keySet())
			if (!list.contains(o)){
				getInnerPanel().removeChild(map.get(o));
				map.remove(o);
			}
				
	}

	protected void configureButton(Button b, Object o) {
		
	}

	int n=1;
	protected Button createButtonFor(Object o) {
		Button b= new Button();
		b.setSize(45, 45);
		b.setPos(Constants.NEXT,Constants.PREVIOUS);
		b.addButtonListener(this);
		b.setAction("SELECT"+n++);
		b.setActOnScene(false);
		getPanelFor(o).addChild(b);
		return b;
	}
	
	
	
	
	protected Panel getPanelFor(Object o) {
		return getInnerPanel();
	}

	public Object getSelected() {
		return selected;
	}
	
	public Button getSelectedButton(){
		if (selected!=null)
			return map.get(selected);
		return null;
	}

	@Override
	public void buttonActivated(Player p, Button b) {
		if (selected!=null)
			if (map.get(selected)!=null)
				map.get(selected).setActivated(false);
		selected=map2.get(b);
		b.setActivated(true);
	}
	
	
	
}
