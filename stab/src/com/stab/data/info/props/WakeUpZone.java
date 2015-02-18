package com.stab.data.info.props;

import com.stab.data.actions.player.spells.ActionDummy;
import com.stab.data.actions.traps.WakeDormants;
import com.stab.model.action.Action;
import com.stab.model.action.ActionLibrary;
import com.stab.model.info.Info;


public class WakeUpZone extends TriggerArea {

	public static final String ID="WAKEUP";
	
	
	
	
	@Override
	protected void onEnter(Info info) {
		super.onEnter(info);
		Action wake= ActionLibrary.getActionLibrary().getAction(WakeDormants.ID);
		if (wake!=null){
			ActionDummy dummy= new ActionDummy();
			dummy.setPos(this.getCenter());
			dummy.setSize(1,1);
			getScene().add(dummy);
			int result=wake.execute(dummy, null, dummy.getPos(), null);
			dummy.destroy();
		}
			
	}
	
}
