package com.stab.data.actions.player.spells.wizard.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.data.info.props.Crate;
import com.stab.model.info.Info;

public class DancingLights extends SpellOnTile{

	public static final String ID="DANCINGLIGHTS";
	
	public DancingLights() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(22);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("DancingLights");
	     this.setEffectType(SPECIAL);
		}


	@Override
	public boolean execute(Info i, int x, int y) {
		
		Crate b=new Crate();
		b.setPos(x,y);
		i.getScene().add(b);
		return true;
	}
}
