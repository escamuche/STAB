package com.stab.data.info.player.abilities;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.AttributeBasedModifier;
import com.stab.model.info.trait.base.Buff;

public class BardicKnowledge extends Buff {
	
	public static final String ID="BARDICKNOWLEDGE";
	
	public BardicKnowledge() {
				         
		this.setUnique(true);
		
		this.addTrait(new AttributeBasedModifier(StabConstants.KNOWLEDGEARCANA,StabConstants.BARDCASTER));
		
		}
	
	
}