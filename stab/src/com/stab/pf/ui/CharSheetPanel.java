package com.stab.pf.ui;

import com.stab.client.slick.BasicActionsController;
import com.stab.common.Constants;
import com.stab.model.basic.ui.Text;
import com.stab.model.basic.ui.advanced.ColoredTextValueLink;
import com.stab.model.basic.ui.advanced.StatsPanel;
import com.stab.pf.StabConstants;

public class CharSheetPanel extends StatsPanel {

	
	
	@Override
	public void init() {
		super.init();
		this.setBackground("ui/csheet$S");
		this.setPos(Constants.BEGIN,60);
		this.setSize(480,512);
		text(StabConstants.STRENGHT,28,17,1);
		text(StabConstants.DEXTERITY,28,27,1);
		text(StabConstants.CONSTITUTION,28,37,1);
		text(StabConstants.INTELLIGENCE,28,47,1);
		text(StabConstants.WISDOM,28,57,1);
		text(StabConstants.CHARISMA,28,67,1);
		
		text(StabConstants.FORTITUDESAVE,80,17);
		text(StabConstants.REFLEXSAVE,80,27);
		text(StabConstants.WILLSAVE,80,37);
		setOpenAction(BasicActionsController.CHARACTER_SHEET);
		
	}
	
	
	
	protected Text text(String val, int px, int py, int type) {
		Text t= new Text();
		t.setSize(Constants.CONTENT,Constants.CONTENT);
		t.setPos(Constants.PERCENT+px,Constants.PERCENT+py);
		addChild(t);
		link(val,t,type);
		return t;
	}
	
	public void link(String field,Text text,int type){
		ColoredTextValueLink tv= new ColoredTextValueLink(field, text);
		addLink(tv);
	}
	
	
}
