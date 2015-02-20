package com.stab.data.adventure.duskwood;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellUtils;
import com.stab.pf.actions.player.spells.cleric.level1.CureLight;
import com.stab.pf.info.monster.Construct;

public class DesnaChalice extends Construct {
	public static final String ID="DESNARELIC";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(0);
		
		
		setFaction(0);
		
		setResource("chalice");
		setText("Desna's chalice");
		this.setDescription("A holy relic from Desna, emanating holy power");
		this.showAlertFromEnemy=false;
		
		
		this.setAttribute(StabConstants.STRENGHT,0);
		this.setAttribute(StabConstants.DEXTERITY,0);
		this.setAttribute(StabConstants.CONSTITUTION,10);
		this.setAttribute(StabConstants.WISDOM,10);
		this.setAttribute(StabConstants.CHARISMA,10);
		this.setAttribute(StabConstants.HITDICENUMBER, 5);
		
			
		setMaxEp(30);
		
		this.getActionSet().addAction(SpellUtils.asCaster(CureLight.ID,StabConstants.CLERICCASTER,1));
		
		
		
		this.setAttribute(StabConstants.CLERICCASTER, 5);
		
		
		
		//getAIParams().setLog(true);
		
	
		
	}
}
