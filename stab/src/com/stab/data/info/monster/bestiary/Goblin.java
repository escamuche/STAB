package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.info.ai.FlankAI;
import com.stab.data.info.alignment.Evil;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;
import com.stab.data.info.monster.Humanoid;
import com.stab.model.ai.traits.Agressor;
import com.stab.model.ai.traits.DangerMapAI;
import com.stab.model.ai.traits.DistanceMapAI;
import com.stab.model.ai.traits.Hatred;
import com.stab.model.ai.traits.SelfPreservation;

public class Goblin extends Humanoid {


	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		setResource("goblin");
		setText("Goblin");
		this.addTrait(new ImprovedInitiative_Feat());
		
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.STRENGHT,11);
		this.setAttribute(StabConstants.DEXTERITY,15);
		this.setAttribute(StabConstants.INTELIGENCE,10);
		this.setAttribute(StabConstants.CONSTITUTION,12);
		this.setAttribute(StabConstants.WISDOM,9);
		this.setAttribute(StabConstants.CHARISMA,6);
		this.setAttribute(StabConstants.SIZE,StabConstants.SMALL_SIZE);
		this.setAttribute(StabConstants.HITDICENUMBER, 1);
	
			
		
		this.addTrait(new Evil());
		
	
		this.addTrait(new SelfPreservation());
		this.addTrait(new Agressor());
		this.addTrait(new FlankAI(1.0f));
	//	this.addTrait(new DangerMapAI());
	//	this.addTrait(new DistanceMapAI());
		this.addTrait(new Hatred(Zombie.class));
		
		
		
	}
	
}
