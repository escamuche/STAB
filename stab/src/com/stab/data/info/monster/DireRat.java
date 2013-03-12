package com.stab.data.info.monster;

import com.stab.data.StabConstants;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.feat.general.SkillFocusPerception_Feat;
import com.stab.model.action.BasicActionSet;
import com.stab.model.ai.DefaultAIPackage;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.Modifier;

public class DireRat extends Creature {

	public static final String ID="DIRERAT_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(8);
		setMaxHp(5);
		healFully();
		
		this.setActionSet(new BasicActionSet());
		//this.getActionSet().addAction(GoblinMeleeAction.ID);
		
		
		setResource("direrat");
		setText("Dire Rat");
		setFaction(1);
		this.addTrait(new BasicAttributes());
		
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.FORTITUDESAVE,+2);
		this.setAttribute(StabConstants.REFLEXSAVE,+2);
		this.setAttribute(StabConstants.INTELIGENCE,2);
		this.setAttribute(StabConstants.DEXTERITY,17);
		this.setAttribute(StabConstants.CONSTITUTION,13);
		this.setAttribute(StabConstants.WISDOM,13);
		this.setAttribute(StabConstants.CHARISMA,4);
		
		Modifier size = new Modifier().createMod(StabConstants.ARMOR,StabConstants.SIZEMOD,+1);
		Modifier hit = new Modifier().createMod(StabConstants.TOHIT,StabConstants.SIZEMOD,+1);
	
		this.addTrait(size);
		this.addTrait(hit);

		this.setCurrentAI(new DefaultAIPackage());
			
		this.addTrait(new SkillFocusPerception_Feat());
		
		//falta special:Filth fever
		
		this.setBloodeffEct("PARTICLE#redblood");
	}
	
	/*@Override
	MeleeMonsterActionSet(){
		this.addAction(GoblinMeleeAction.ID);
	}*/
}