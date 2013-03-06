package com.stab.data.info.monster;

import com.stab.data.StabConstants;
import com.stab.data.info.BasicAttributes;
import com.stab.model.ai.DefaultAIPackage;
import com.stab.model.info.base.Creature;

public class Zombie extends Creature {

	public static final String ID="ZOMBIE_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(4);
		setMaxHp(12);
		healFully();
		this.setActionSet(new MeleeMonsterActionSet());
		setResource("zombie");
		setText("Zombie");
		setFaction(1);
		this.addTrait(new BasicAttributes());
		/*this.setAttribute(StabConstants.ARMOR,12);
		this.setAttribute(StabConstants.TOHIT,2);
		this.setAttribute(StabConstants.DAMAGE,1);*/
		
	//	this.setCurrentAI(new DefaultAIPackage());
		this.setCurrentAI(new ZombieAIPackage());
		
		
		this.setBloodeffEct("PARTICLE#greenblood");
	}
	
}
