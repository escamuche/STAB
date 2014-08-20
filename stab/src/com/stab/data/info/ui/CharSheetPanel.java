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
		text(StabConstants.STRENGHT,28,17);
		text(StabConstants.DEXTERITY,28,27);
		text(StabConstants.CONSTITUTION,28,37);
		text(StabConstants.INTELLIGENCE,28,47);
		text(StabConstants.WISDOM,28,57);
		text(StabConstants.CHARISMA,28,67);
		
		text(StabConstants.FORTITUDESAVE,80,17);
		text(StabConstants.REFLEXSAVE,80,27);
		text(StabConstants.WILLSAVE,80,37);
		
	}
	
	
	@Override
	protected Text text(String val, int px, int py) {
		Text t= super.text(val, px, py);
		t.setText("--");
		return t;
	}
	
	public void link(String field,Text text){
		ColoredTextValueLink tv= new ColoredTextValueLink(field, text);
		links.add(tv);
	}
	
	
}
