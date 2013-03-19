package com.stab.data.info.props;

import com.stab.data.StabConstants;
import com.stab.model.info.base.Obstacle;
import com.stab.model.info.trait.Modifier;

public class Dummy extends Obstacle {

   public static final String ID="DUMMY";

	
	public void init() {
		super.init();
		setMaxHp(70);
		setMaxEp(0);
		healFully();
		setResource("dummy");
		setText("");
		this.addTrait(Modifier.createMod(StabConstants.ARMORDEFENSE,StabConstants.ARMORMOD,2));
	
	//	this.setActionSet(new WarriorActionSet());
	//	this.setCurrentAI(new DefaultAIPackage());
	}
	
	@Override
	public void die() {
		super.die();
		setResource("BarrilRoto");
	}
	
}