package com.stab.data.actions.player.spells.lvl0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.data.actions.player.spells.SpellProperties;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.info.Info;

public class DancingLights extends SpellOnTile   {

	public static final String ID="DANCINGLIGHTS";
	
	public DancingLights() {
		setAoE(false);
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(CLOSE);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("DancingLights");
	     this.setEffectType(Action.SPECIAL);
	     this.setDuration(SpellProperties.FIXED);
	     
		}




}
