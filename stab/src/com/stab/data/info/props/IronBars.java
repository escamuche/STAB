package com.stab.data.info.props;

import com.stab.model.info.Info;
import com.stab.model.info.base.Door;

public class IronBars extends Door {

	public static final String ID="IRON_BARS";
	
	public void init() {
		super.init();
		setMaxHp(60);
		setMaxEp(0);
		healFully();
		setResource("ironBarsOn");
		setText("Bars");
		setDescription("Sturdy iron bars blocking the way");
	}
	
	
	protected void open(){
	
		playSound("door_open");
		setResource("ironBarsOff");
		super.open();
	}
	
	protected void close(){
		playSound("door_close");
		setResource("ironBarsOn");
		super.close();
	}
	
	
	@Override
	protected boolean canOpen(Info actor) {
		if (actor!=this)   //Para solo permitir que se abra por mecanismos
			return false;
		return super.canOpen(actor);
	}
	
	@Override
	protected boolean canClose(Info actor) {
		if (actor!=this)   //Para solo permitir que se abra por mecanismos
			return false;
		return super.canClose(actor);
	}
	
}

