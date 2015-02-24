package com.stab.base.info.props;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.base.Obstacle;
import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.applicable.PathfinderAttack;

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
		if(a.isRanged())
		if (this.getMapLogic().isAdyacent(this, a.getInstigator())) //No penalizar por cover adyacente al atacante
			return;
		a.attended(this);
		int bonus=getCoverBonus(a.getTarget());

		a.addModifier(new Modifier(StabConstants.PASSIVEDEFENSE,StabConstants.COVER,bonus));
		
		//registrarse como cover
		a.registerAsCover(this);
	}

	protected int getCoverBonus(BaseInfo target) {
		// TODO calcular cover bonus en base a los tamaños relativos?
		return 4;
	}

}
