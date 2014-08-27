package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.info.alignment.Chaotic;
import com.stab.data.info.alignment.Evil;
import com.stab.data.info.feat.combat.Dodge_Feat;
import com.stab.data.info.feat.general.SkillFocusPerception_Feat;
import com.stab.data.info.monster.Undead;
import com.stab.data.info.monster.ZombieAIParameters;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.Modifier;

public class Shadow extends Undead {

	public static final String ID="SHADOW_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		setResource("shadow");
		setText("Shadow");
		this.setBloodeffEct("PARTICLE#damage/essenceburst");
	
		this.addTrait(new Attribute(StabConstants.INTELLIGENCE,6));
		this.addTrait(new Attribute(StabConstants.DEXTERITY,14));
		this.addTrait(new Attribute(StabConstants.WISDOM,12));
		this.addTrait(new Attribute(StabConstants.CHARISMA,14));
		this.addTrait(new Attribute(StabConstants.XP,800));
		this.addTrait(new Attribute(StabConstants.HITDICENUMBER, 3));
		
		this.addTrait(new SkillFocusPerception_Feat());
		this.addTrait(new Dodge_Feat());
		
		this.addTrait(new Evil());
		this.addTrait(new Chaotic());
		
		Modifier armordeflection=new Modifier(StabConstants.ARMORDEFENSE,StabConstants.DEFLECTIONMOD, +2);
		this.addTrait(armordeflection);
		
		this.setAIParams(new ZombieAIParameters());
		
	}
	
}