package com.stab.data.info.monster;

import com.stab.data.StabConstants;
import com.stab.data.actions.monster.GoblinMeleeAction;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.buff.ImprovedInitiative_Buff;
import com.stab.model.action.BasicActionSet;
import com.stab.model.ai.DefaultAIPackage;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.Modifier;

public class Goblin extends Creature {

	public static final String ID="GOBLIN_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setMaxHp(6);
		healFully();
		
		this.setActionSet(new BasicActionSet());
		this.getActionSet().addAction(GoblinMeleeAction.ID);
		
		
		setResource("goblin");
		setText("Goblin");
		setFaction(1);
		this.addTrait(new BasicAttributes());
		
		this.setAttribute(StabConstants.XP,135);
		this.setAttribute(StabConstants.FORTITUDESAVE,+2);
		this.setAttribute(StabConstants.TOHIT,+1);
		this.setAttribute(StabConstants.TOHITRANGED,+1);
		this.setAttribute(StabConstants.STRENGHT,11);
		this.setAttribute(StabConstants.DEXTERITY,15);
		this.setAttribute(StabConstants.CONSTITUTION,12);
		this.setAttribute(StabConstants.WISDOM,9);
		this.setAttribute(StabConstants.CHARISMA,6);
		
		Modifier armor = new Modifier().createMod(StabConstants.ARMOR,StabConstants.ARMORMOD,+2);
		Modifier shield = new Modifier().createMod(StabConstants.ARMOR,StabConstants.SHIELDMOD,+1);
		Modifier size = new Modifier().createMod(StabConstants.ARMOR,StabConstants.SIZEMOD,+1);
		Modifier hit = new Modifier().createMod(StabConstants.TOHIT,StabConstants.SIZEMOD,+1);
		Modifier hitranged = new Modifier().createMod(StabConstants.TOHITRANGED,StabConstants.SIZEMOD,+1);
	
		ImprovedInitiative_Buff buff = new ImprovedInitiative_Buff(this);
		
		this.addTrait(armor);
		this.addTrait(buff);
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