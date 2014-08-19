package com.stab.data.info.ui;

import com.stab.common.Constants;
import com.stab.data.StabConstants;
import com.stab.model.basic.ui.Text;

public class CharSheetPanel extends StatsPanel {

	
	
	@Override
	public void init() {
		super.init();
		this.setBackground("ui/csheet$S");
		this.setPos(Constants.BEGIN,60);
		this.setSize(480,512);
		text(StabConstants.STRENGHT,32,20);
		text(StabConstants.DEXTERITY,32,30);
		text(StabConstants.CONSTITUTION,32,40);
		text(StabConstants.INTELLIGENCE,32,50);
		text(StabConstants.WISDOM,32,60);
		text(StabConstants.CHARISMA,32,70);
		//this.setVisible(false);
	}
	
	
	@Override
	protected Text text(String val, int px, int py) {
		Text t= super.text(val, px, py);
		t.setText("--");
		return t;
		
	}
}
