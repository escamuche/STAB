package com.stab.data.actions.player.spells;

import java.awt.Point;

import com.stab.annotations.Instanced;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.model.action.Action;
import com.stab.model.action.ContextualAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

//De hecho, no deberia ser instanciada ni registrada en la library
@Instanced
public class ActivateSpellEffectAction  extends ContextualAction{

	
	public static final String ID="ACTIVATE_SPELLEFFECT_ACTION";
	
	
	SpellEffect effect;
	int slot=1;
	boolean shouldEndTurn=false;
	
	public ActivateSpellEffectAction(SpellEffect effect){
		this(effect,1);
	}
	public ActivateSpellEffectAction(SpellEffect effect,int slot) {
		this.effect=effect;
		setRange(SELF);
		setTargetMode(Action.SELF);//mirar esto bien
		setName("Activate "+effect.getName());
		setResource(effect.getResource());
		setDescription("Activate the spell effect");
		setLosType(IN_RANGE);
		setTargetInfoClass(Info.class);
		setCost(0);
		setAPCost(0);
	}
	
	public void setShouldEndTurn(boolean shouldEndTurn) {
		this.shouldEndTurn = shouldEndTurn;
	}
	
	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return shouldEndTurn;
	}


	@Override
	public int affect(Info instigator, Info target, Point point,
			ActionRequest ar) {

		effect.activate(slot,(BaseInfo)instigator,target,point);
		
		return OK;
	}
}
