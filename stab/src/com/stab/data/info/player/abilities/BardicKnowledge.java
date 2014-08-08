package com.stab.data.info.player.abilities;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.AttributeBasedModifier;
import com.stab.model.info.trait.base.BuffEffect;

public class BardicKnowledge extends BuffEffect {
	
	public static final String ID="BARDICKNOWLEDGE_BUFF";
	
	public BardicKnowledge() {
		        
		this.setName("Bardid Knowledge");
		this.setUnique(true);
		this.setPermanent();
		
		this.addTrait(new AttributeBasedModifier(StabConstants.KNOWLEDGEARCANA,StabConstants.BARDCASTER));
		this.addTrait(new AttributeBasedModifier(StabConstants.KNOWLEDGEDUNGEONEERING,StabConstants.BARDCASTER));
		this.addTrait(new AttributeBasedModifier(StabConstants.KNOWLEDGEENGINEERING,StabConstants.BARDCASTER));
		this.addTrait(new AttributeBasedModifier(StabConstants.KNOWLEDGEGREOGRAPPHY,StabConstants.BARDCASTER));
		this.addTrait(new AttributeBasedModifier(StabConstants.KNOWLEDGEHISTORY,StabConstants.BARDCASTER));
		this.addTrait(new AttributeBasedModifier(StabConstants.KNOWLEDGELOCAL,StabConstants.BARDCASTER));
		this.addTrait(new AttributeBasedModifier(StabConstants.KNOWLEDGENATURE,StabConstants.BARDCASTER));
		this.addTrait(new AttributeBasedModifier(StabConstants.KNOWLEDGENOBILITY,StabConstants.BARDCASTER));
		this.addTrait(new AttributeBasedModifier(StabConstants.KNOWLEDGEPLANES,StabConstants.BARDCASTER));
		this.addTrait(new AttributeBasedModifier(StabConstants.KNOWLEDGERELIGION,StabConstants.BARDCASTER));

		}
	
}