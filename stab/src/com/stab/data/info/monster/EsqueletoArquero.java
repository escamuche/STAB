package com.stab.data.info.monster;

import com.stab.data.info.BasicAttributes;
import com.stab.model.ai.DefaultAIPackage;
import com.stab.model.info.base.Creature;

public class EsqueletoArquero extends Creature {

	public static final String ID="ESQUELETOARQUERO_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setMaxHp(8);
		healFully();
		this.setActionSet(new RangedMonsterActionSet());
		setResource("skeleto");
		setText("EsqueletoArquero");
		setFaction(1);
		this.addTrait(new BasicAttributes());
		
	//	this.setCurrentAI(new DefaultAIPackage());
		this.setCurrentAI(new ZombieAIPackage());
		
		
		this.setBloodeffEct("PARTICLE#greenblood");
	}
	
}