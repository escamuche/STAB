package com.stab.data.actions.player.spells;

import java.awt.Point;

import com.stab.data.info.SpellDecoration;
import com.stab.model.action.ContextualAction;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;


public class DismissSpellAction extends ContextualAction {
	
	public static final String ID="DISMISS_SPELL_ACTION";
	
	
	public DismissSpellAction() {
		setRange(5);
		setName("Dismiss spell");
		setResource("actions/spells/dismiss");
		setDescription("Dismiss the active spell, ending it");
		setLosType(IN_SIGHT);
		setTargetInfoClass(SpellDecoration.class);
	}


	@Override
	public int affect(Info instigator, Info target, Point point,
			ActionRequest ar) {

		((SpellDecoration)target).getSpellEffect().end();
		return OK;
	}
}
