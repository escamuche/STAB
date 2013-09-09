package com.stab.data.info.equipment;

import java.awt.Point;

import com.stab.data.actions.player.spells.SpellAction;
import com.stab.data.info.applicable.ActionEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.request.basic.ActionRequest;

public class SpellActionEffect extends ActionEffect {
	
	public static final int EVADED=40;
	public static final int RESISTED=41;
	public static final int SAVED=42;
	
	boolean critical=false;
	
	
	public SpellActionEffect(BaseInfo instigator, BaseInfo target, Point point,
			String action,ActionRequest ar) {
		super(instigator, target, point, action,ar);
	}

	public void setCritical(boolean critical) {
		this.critical = critical;
	}
	public boolean isCritical() {
		return critical;
	}
	
	@Override
	public void applyEffects() {
		int i=((SpellAction)getAction()).spellAffect((BaseInfo)getInstigator(), this.getTarget(),getPoint(),isCritical(),this.getActionRequest());
		this.setResult(i); //Revisar, aqui hay algo raro (eso de reutilizar suena muy raro)
		setCritical(false); //Por si lo reutilizamos
	}

}
