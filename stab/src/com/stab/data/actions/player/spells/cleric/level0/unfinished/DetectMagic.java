package com.stab.data.actions.player.spells.cleric.level0.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;


public class DetectMagic extends SpellOnSelf{
	public static final String ID="DETECTMAGIC_CLERIC";

	public DetectMagic() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.CLERICCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("DetectMagic");
	     this.setEffectType(BUFF);
		}



	@Override
	public boolean affect(Info instigator, Info receptor,Point point) {
		
	
		return false;
	}
}