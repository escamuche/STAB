package com.stab.data.actions.player;

import com.stab.data.animation.DefendAnimation;
import com.stab.model.action.SelfAction;
import com.stab.model.events.common.ConsoleMessage;
import com.stab.model.info.BaseInfo;
import com.stab.model.request.basic.ActionRequest;

public class DefendAction extends SelfAction {
	
	public static final String ID="DEFEND";
	
	public DefendAction() {
		this.setName("Defend");
		this.setResource("actions/ability_warrior_defensivestance");
		
	}
	
	@Override
	public boolean execute(BaseInfo self) {
		self.playAnimation(DefendAnimation.ID);
		self.getScene().sendMessage(ConsoleMessage.SUCCESS, self.getText()+" defends");
		return true;
	}
	
	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return true;
	}
	
}
