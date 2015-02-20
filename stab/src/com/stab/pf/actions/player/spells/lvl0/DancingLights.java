package com.stab.pf.actions.player.spells.lvl0;

import java.awt.Point;

import com.stab.data.actions.EffectDescriptor;
import com.stab.model.action.Action;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTile;
import com.stab.pf.actions.player.spells.SpellProperties;
import com.stab.pf.actions.player.spells.lvl0.effects.DancingLights_Buff;
import com.stab.pf.actions.player.spells.lvl0.effects.DancingLights_effect;

public class DancingLights extends SpellOnTile   {

	public static final String ID="DANCINGLIGHTS";
	
	public DancingLights() {
		setAoE(true);
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(CLOSE);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("DancingLights");
	     setDescription("Creates a display of dancing lights that illuminate a small area.");
	     this.setEffectType(Action.SPECIAL);
	     this.setDuration(SpellProperties.FIXED);
	     setDescriptors(EffectDescriptor.EVOCATION,EffectDescriptor.LIGHT);
	     
		}

	@Override
	public int execute(Info origin, Info target, Point point, ActionRequest ar) {
		BaseInfo caster=(BaseInfo)origin;
		if (caster.getTrait(DancingLights_Buff.class)!=null)
			((DancingLights_Buff)(caster.getTrait(DancingLights_Buff.class))).end();
		DancingLights_effect eff= new DancingLights_effect();
		DancingLights_Buff buff = new DancingLights_Buff();
		buff.setEffect(eff);
		eff.setPos(point);
		caster.getScene().add(eff);
		caster.addTrait(buff);
		
		return OK;
	}


	@Override
	public int getRequiredLine() {
		return IN_SIGHT;
	}
	
	public float getLength(Info caster) {
		return 2; 
	}
	
}
