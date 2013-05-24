package com.stab.data.info.equipment;

import java.awt.Point;

import com.stab.data.actions.player.spells.SpellAction;
import com.stab.data.info.applicable.ActionEffect;
import com.stab.model.info.BaseInfo;

public class SpellActionEffect extends ActionEffect {
	
	
	boolean critical=false;
	
	
	public SpellActionEffect(BaseInfo instigator, BaseInfo target, Point point,
			String action) {
		super(instigator, target, point, action);
	}

	public void setCritical(boolean critical) {
		this.critical = critical;
	}
	public boolean isCritical() {
		return critical;
	}
	
	@Override
	public void applyEffects() {
		((SpellAction)getAction()).spellAffect((BaseInfo)getInstigator(), this.getTarget(),getPoint(),isCritical());
		setCritical(false); //Por si lo reutilizamos
	}

}
