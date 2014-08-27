package com.stab.data.info.props;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.lvl0.DetectMagic;
import com.stab.model.extras.OnlyVisibleWithMode;
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