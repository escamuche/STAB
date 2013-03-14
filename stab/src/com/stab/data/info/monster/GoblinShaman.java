package com.stab.data.info.monster;

import com.stab.data.StabConstants;
import com.stab.data.actions.monster.GoblinMeleeAction;
import com.stab.data.actions.player.spells.cleric.level1.CureLight;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;
import com.stab.model.action.BasicActionSet;
import com.stab.model.ai.DefaultAIPackage;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.Modifier;

public class GoblinShaman extends Creature {

	public static final String ID="GOBLINSHAMAN_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setMaxHp(6);
		healFully();
		
		this.setActionSet(new BasicActionSet());
		this.getActionSet().addAction(GoblinMeleeAction.ID);
		this.getActionSet().addAction(CureLight.ID);
		
		
		setResource("goblinshaman");
		setText("Goblin Shaman");
		setFaction(2);
		this.addTrait(new BasicAttributes());
		this.addTrait(new ImprovedInitiative_Feat());
		
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.FORTITUDESAVE,+2);
		this.setAttribute(StabConstants.TOHIT,+1);
		this.setAttribute(StabConstants.TOHITRANGED,+1);
		this.setAttribute(StabConstants.STRENGHT,11);
		this.setAttribute(StabConstants.DEXTERITY,15);
		this.setAttribute(StabConstants.CONSTITUTION,12);
		this.setAttribute(StabConstants.WISDOM,14);
		this.setAttribute(StabConstants.CHARISMA,6);
		
		Modifier armor = new Modifier().createMod(StabConstants.ARMOR,StabConstants.ARMORMOD,+2);
		Modifier shield = new Modifier().createMod(StabConstants.ARMOR,StabConstants.SHIELDMOD,+1);
		Modifier size = new Modifier().createMod(StabConstants.ARMOR,StabConstants.SIZEMOD,+1);
		Modifier hit = new Modifier().createMod(StabConstants.TOHIT,StabConstants.SIZEMOD,+1);
		Modifier hitranged = new Modifier().createMod(StabConstants.TOHITRANGED,StabConstants.SIZEMOD,+1);
	
		
		this.addTrait(armor);
		this.addTrait(size);
		this.addTrait(hit);
		this.addTrait(hitranged);

		this.setCurrentAI(new DefaultAIPackage());
			
		this.setBloodeffEct("PARTICLE#redblood");
	}
	
	/*@Override
	MeleeMonsterActionSet(){
		this.addAction(GoblinMeleeAction.ID);
	}*/
}