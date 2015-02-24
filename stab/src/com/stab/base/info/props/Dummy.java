package com.stab.base.info.props;

import com.stab.model.extras.OnlyVisibleWithMode;
import com.stab.model.info.base.Obstacle;
import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.lvl0.DetectMagic;

public class Dummy extends Obstacle {

   public static final String ID="DUMMY";

	
	public void init() {
		super.init();
		setMaxHp(20);
		setMaxEp(0);
		healFully();
		setResource("dummy");
		setDestroyedResource("BarrilRoto");
		setText("Target dummy");
		setDescription("A training dummy");
		this.addTrait(new Modifier(StabConstants.ARMORDEFENSE,StabConstants.ARMORMOD,2));
		this.setBloodeffEct("PARTICLE#damage/splinterburst");
	
	//	this.setActionSet(new WarriorActionSet());
	//	this.setCurrentAI(new DefaultAIPackage());
		this.addExtra(new OnlyVisibleWithMode(DetectMagic.VISIONMODE));
	}
	
	
	
}