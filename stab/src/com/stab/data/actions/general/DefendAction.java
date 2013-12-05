package com.stab.data.actions.general;

import java.awt.Point;

import com.stab.data.actions.PathfinderAction;
import com.stab.data.info.buff.Defend_Buff;
import com.stab.model.action.Action;
import com.stab.model.action.SelfAction;
import com.stab.model.events.common.ConsoleMessage;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class DefendAction extends PathfinderAction implements SelfAction {
	
	public static final String ID="DEFEND";
	
	public DefendAction() {
		this.setName("Defend");
		this.setResource("actions/ability_warrior_defensivestance");
		this.setEffectType(BUFF);
		this.setAiCap(500);
		setRelations(Action.TARGET_SELF);
		this.setRange(0);
		setDefaultAIValue(600);
	}
	
	@Override
	public int affect(Info instigator,Info target,Point point,ActionRequest ar) {
		BaseInfo self=(BaseInfo)target;
		//self.playAnimation(DefendAnimation.ID);
		self.sendMessage(ConsoleMessage.SUCCESS, self.getText()+" defends");
		
	//	Modifier masdosalaCA= new Modifier("CA", +2);  // Creamos un modificador de +2 a la ca
	//	Effect buffqueduraunround = Effect.createRound("Nombre innecesario de ejemplo", masdosalaCA); //creamos un efecto que dura 1 round, y que aplica ese modificador (y lo quita cuando se pasa)
		
	//	self.addTrait(buffqueduraunround); //nos añadimos el buff
		
		self.addTrait(new Defend_Buff());
		
		return OK;
	}
	
	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return true;
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 5;
	}
}
