package com.stab.data.info.equipment;

import java.awt.Point;
import java.util.EnumSet;

import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.HasDescriptor;
import com.stab.data.actions.player.spells.Spell;
import com.stab.data.actions.player.spells.SpellAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.ActionEffect;
import com.stab.model.request.basic.ActionRequest;

public class SpellActionEffect extends ActionEffect implements HasDescriptor{
	
	public static final int EVADED=40;
	public static final int RESISTED=41;
	public static final int SAVED=42;
	
	boolean critical=false;
	
	protected EnumSet<EffectDescriptor> descriptors;
	
	
	public SpellActionEffect(BaseInfo instigator, BaseInfo target, Point point,
			String action,ActionRequest ar) {
		super(instigator, target, point, action,ar);
	}

	
	
	@Override
	public void applyEffects() {
		int i=((SpellAction)getAction()).spellAffect((BaseInfo)getInstigator(), this.getTarget(),getPoint(),isCritical(),this.getActionRequest());
		this.setResult(i); //Revisar, aqui hay algo raro (eso de reutilizar suena muy raro)
		setCritical(false); //Por si lo reutilizamos
	}



	@Override
	public EnumSet<EffectDescriptor> getDescriptors() {
		return descriptors;
	}



	public void setDescriptors(EffectDescriptor arg0) {
		descriptors= EnumSet.of(arg0);
	}



	public void setDescriptors(EffectDescriptor arg0, EffectDescriptor...arg1) {
		descriptors= EnumSet.of(arg0, arg1);
	}

}
