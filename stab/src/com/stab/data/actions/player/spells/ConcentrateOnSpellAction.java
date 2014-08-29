package com.stab.data.actions.player.spells;

import java.awt.Point;

import com.stab.data.info.spellcasting.SpellDecoration;
import com.stab.model.action.Action;
import com.stab.model.action.ContextualAction;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class ConcentrateOnSpellAction extends ContextualAction{

	
	public static final String ID="CONCENTRATE_SPELL_ACTION";
	
	
	
	
	public ConcentrateOnSpellAction() {
		setRange(SELF);
	//	setTargetMode(Action.TARGET);//mirar esto bien
		setName("Concentrate");
		setResource("actions/spells/dismiss");
		setDescription("Keep concentrating on an active spell, extending its effect");
		setLosType(IN_RANGE);
		setTargetInfoClass(SpellDecoration.class);
	}


	@Override
	public int affect(Info instigator, Info target, Point point,
			ActionRequest ar) {

		//getSpellEffect().concentrate();
		return OK;
	}
	
}
