package com.stab.data.actions.player;


import com.stab.data.StabConstants;
import com.stab.data.animation.DefendAnimation;
import com.stab.model.action.SelfAction;
import com.stab.model.events.common.ConsoleMessage;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Effect;
import com.stab.model.info.trait.Modifier;
import com.stab.model.request.basic.ActionRequest;

public class PowerAttack extends SelfAction {
	
	public static final String ID="POWERATT";
	
	public PowerAttack() {
		this.setName("Power");
		this.setResource("actions/ability_backstab");
	
	}
	
	@Override
	public boolean execute(BaseInfo self) {
		
		Modifier dañopoweratt= Modifier.createMod(StabConstants.DAMAGE, +2);
		Modifier tohitpoweratt=Modifier.createMod(StabConstants.TOHIT, -1);
		
		self.playAnimation(DefendAnimation.ID);
		self.sendMessage(ConsoleMessage.SUCCESS, self.getText()+" activa power attack");
		self.getScene().sendMessage(ConsoleMessage.WARNING, "Bono de daño: " + dañopoweratt);
		self.getScene().sendMessage(ConsoleMessage.WARNING, "Negativo a dar: " + tohitpoweratt);

		
		Effect buffdañoround = Effect.createRound("buffdaño", dañopoweratt, tohitpoweratt);
		self.addTrait(buffdañoround);
		

		
		return true;
	}
	
	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return false;
	}
	
}