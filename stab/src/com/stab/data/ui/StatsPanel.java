package com.stab.data.ui;

import java.util.ArrayList;

import com.stab.client.slick.BasicActionsController;
import com.stab.common.Constants;
import com.stab.model.basic.ui.Panel;
import com.stab.model.basic.ui.Text;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.interfaces.PlayerOwned;
import com.stab.model.info.interfaces.ValueChangeListener;

public class StatsPanel extends Panel implements ValueChangeListener{

	BaseInfo info;
	
	ArrayList<TextValueLink> links;
	
	@Override
	public void init() {
		super.init();
		links=new ArrayList<TextValueLink>();
		setOpenAction(BasicActionsController.CHARACTER_SHEET);
		setSize(240,Constants.CONTENT);
		setPos(Constants.BEGIN,Constants.PERCENT+20);
		setBackground("ui/consoleback$X");
		setOverlay("ui/consolefront$X");
		
	}

	public void link(String field,Text text){
		link(field, text,false);
	}
	public void link(String field,Text text,boolean attr){
		TextValueLink tv= new TextValueLink(field, text);
		if (attr)
			tv.attr=true;
		links.add(tv);
	}
	
	public void setInfo(BaseInfo info) {
		this.info = info;
		this.setPlayerRestricted(((PlayerOwned)info).getOwner());
		refresh();
		info.addValueChangeListener(this);
	}
	
	public BaseInfo getInfo() {
		return info;
	}
	
	protected Text text(String val,int px,int py){
		Text t= new Text();
		t.setSize(Constants.CONTENT,Constants.CONTENT);
		t.setPos(Constants.PERCENT+px,Constants.PERCENT+py);
		addChild(t);
		link(val,t);
		return t;
	}
	
	public void refresh(){
		for (TextValueLink tv:links)
			tv.check(getInfo());
	}

	@Override
	public void valueChanged() {
		refresh();
	}
	
}


