package com.stab.data.info.props;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.PathfinderAttack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.base.Obstacle;
import com.stab.model.info.trait.Modifier;

public class Cover extends Obstacle implements Attends<PathfinderAttack>{

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof PathfinderAttack)
			return true;
		return false;
	}

	@Override
	public void attend(PathfinderAttack app) {
		if (app.hasAttended(this)) //No aplicar multiples veces
			return;
		
		PathfinderAttack a=(PathfinderAttack)app;
		if (this.getMapLogic().isAdyacent(this, a.getInstigator())) //No penalizar por cover adyacente al atacante
			return;
		int bonus=getCoverBonus(a.getTarget());
		bonus=20;
		a.addModifier(new Modifier(StabConstants.PASSIVEDEFENSE,StabConstants.COVER,bonus));
		
		//registrarse como cover
		a.registerAsCover(this);
	}

	protected int getCoverBonus(BaseInfo target) {
		// TODO calcular cover bonus en base a los tamaños relativos?
		return 2;
	}

}
