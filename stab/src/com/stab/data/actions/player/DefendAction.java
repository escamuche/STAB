package com.stab.data.actions.player;

import com.stab.data.animation.DefendAnimation;
import com.stab.model.action.SelfAction;
import com.stab.model.events.common.ConsoleMessage;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Effect;
import com.stab.model.info.trait.Modifier;
import com.stab.model.request.basic.ActionRequest;

public class DefendAction extends SelfAction {
	
	public static final String ID="DEFEND";
	
	public DefendAction() {
		this.setName("Defend");
		this.setResource("actions/ability_warrior_defensivestance");
		this.setEffectType(BUFF);
	}
	
	@Override
	public boolean execute(BaseInfo self) {
		self.playAnimation(DefendAnimation.ID);
		self.sendMessage(ConsoleMessage.SUCCESS, self.getText()+" defends");
		
		Modifier masdosalaCA= Modifier.createMod("CA", +2);  // Creamos un modificador de +2 a la ca
		Effect buffqueduraunround = Effect.createRound("Nombre innecesario de ejemplo", masdosalaCA); //creamos un efecto que dura 1 round, y que aplica ese modificador (y lo quita cuando se pasa)
		
		self.addTrait(buffqueduraunround); //nos añadimos el buff
		
		return true;
	}
	
	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return true;
	}
	
}
