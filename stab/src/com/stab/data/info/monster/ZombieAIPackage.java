package com.stab.data.info.monster;

import com.stab.model.action.Action;
import com.stab.model.ai.DefaultAIPackage;

public class ZombieAIPackage extends DefaultAIPackage{

	@Override
	protected double getDangerFactor() {
		return 0; //Al zombie le da igual el peligro
	}

	@Override
	protected int getMovementFactor() {
		return -100; //Penaliza mas aun el movimiento. Los zombies prefieren acciones que impliquen mover menos
	}
	
	@Override
	protected double getFactorForType(int type) {
		if (type==Action.DAMAGE)
			return 2.0;   //Mas multiplicador para las acciones ofensivas. aunque no creo que los zombies tengan opciones defensivas
		return super.getFactorForType(type);
	}
	
	
	@Override
	protected int getRandomFactor() {
		return 20;  //No son muy creativos o aleatorios que digamos
	}
}
