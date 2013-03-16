package com.stab.data.info.monster;

import com.stab.data.StabConstants;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.feat.general.SkillFocusPerception_Feat;
import com.stab.model.action.BasicActionSet;
import com.stab.model.ai.DefaultAIPackage;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.Modifier;

public class Kobold extends Monster {

	public static final String ID="KOBOLD_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setMaxHp(5);
		healFully();
		
		this.setActionSet(new BasicActionSet());
		//this.getActionSet().addAction(GoblinMeleeAction.ID);
		
		
		setResource("kobold");
		setText("Kobold");
		setFaction(1);
		
		
		this.setAttribute(StabConstants.XP,100);
		this.setAttribute(StabConstants.FORTITUDESAVE,+2);
		this.setAttribute(StabConstants.TOHIT,+1);
		this.setAttribute(StabConstants.TOHITRANGED,+1);
		this.setAttribute(StabConstants.STRENGHT,9);
		this.setAttribute(StabConstants.DEXTERITY,13);
		this.setAttribute(StabConstants.WISDOM,9);
		this.setAttribute(StabConstants.CHARISMA,8);
		
		Modifier armor = new Modifier().createMod(StabConstants.ARMOR,StabConstants.ARMORMOD,+2);
		Modifier natural = new Modifier().createMod(StabConstants.ARMOR,StabConstants.NATURALARMORMOD,+1);
		Modifier size = new Modifier().createMod(StabConstants.ARMOR,StabConstants.SIZEMOD,+1);
		Modifier hit = new Modifier().createMod(StabConstants.TOHIT,StabConstants.SIZEMOD,+1);
		Modifier hitranged = new Modifier().createMod(StabConstants.TOHITRANGED,StabConstants.SIZEMOD,+1);
		
		this.addTrait(armor);
		this.addTrait(natural);
		this.addTrait(size);
		this.addTrait(hit);
		this.addTrait(hitranged);
		
		this.addTrait(new SkillFocusPerception_Feat());

		this.setCurrentAI(new DefaultAIPackage());
			
		this.setBloodeffEct("PARTICLE#redblood");
	}
	
	/*@Override
	MeleeMonsterActionSet(){
		this.addAction(GoblinMeleeAction.ID);
	}*/
}