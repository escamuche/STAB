package com.stab.pf.info.monster.bestiary;

import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.alignment.Chaotic;
import com.stab.pf.info.alignment.Evil;
import com.stab.pf.info.feat.combat.Dodge_Feat;
import com.stab.pf.info.feat.general.SkillFocusPerception_Feat;
import com.stab.pf.info.monster.Undead;
import com.stab.pf.info.monster.ZombieAIParameters;

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