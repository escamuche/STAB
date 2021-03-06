package com.stab.base.info.props;

import java.awt.Point;

import com.stab.model.action.Action;
import com.stab.model.basic.token.Token;
import com.stab.model.info.ActionDummy;
import com.stab.model.info.Info;
import com.stab.model.info.base.TriggerArea;
import com.stab.util.StabUtils;

public class CaveIn  extends TriggerArea {
	
	public static final String ID="CAVE_IN";
	
	@Override
	public void init() {
		super.init();
		setResource("marks/warning1");
		setHideCheck(10);
		
		setDescription("The ceiling in this area is unstable. It may collapse.");
		this.setSelectable(Token.SELECTABLE);
	}

	static String[] res={"marks/runeTrap1","marks/runeTrap2","marks/runeTrap3"};
	
	@Override
	protected void onEnter(Info info) {
		Action a=StabUtils.getActionLibrary().getAction(com.stab.base.actions.traps.CaveIn.ID);
		Point p=info.getPos();
		ActionDummy dummy= new ActionDummy();
		dummy.setPos(this.getCenter());
		dummy.setSize(1,1);
		getScene().add(dummy);
		int result=a.execute(dummy, null, p, null);
		dummy.destroy();
		destroy();
	
	}
	
}
