package com.stab.data.info.monster;

import com.stab.data.StabConstants;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.buff.ImprovedInitiative_Buff;
import com.stab.model.ai.DefaultAIPackage;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.Modifier;

public class EsqueletoArquero extends Creature {

	public static final String ID="ESQUELETOARQUERO_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setMaxHp(4);
		healFully();
		this.setActionSet(new RangedMonsterActionSet());
		setResource("skeleto");
		setText("EsqueletoArquero");
		setFaction(1);
		this.addTrait(new BasicAttributes());
		this.addTrait(new Attribute(StabConstants.STRENGHT,15));
		this.addTrait(new Attribute(StabConstants.DEXTERITY,14));
		this.addTrait(new Attribute(StabConstants.WILLSAVE,+2));
		this.addTrait(new Attribute(StabConstants.XP,135));
		ImprovedInitiative_Buff ini = new ImprovedInitiative_Buff(this);
		Modifier armor=Modifier.createMod(StabConstants.ARMOR,StabConstants.ARMORMOD, +2);
		Modifier armornatural=Modifier.createMod(StabConstants.ARMOR,StabConstants.NATURALARMORMOD, +2);
		
		this.addTrait(ini);
		this.addTrait(armor);
		this.addTrait(armornatural);
		
		

		
	//	this.setCurrentAI(new DefaultAIPackage());
		this.setCurrentAI(new ZombieAIPackage());
		
		
		this.setBloodeffEct("PARTICLE#greenblood");
	}
	
}