package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.data.info.HalfBonusModifier;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class BardicKnowledge_Buff extends Buff {
	
	public static final String ID="BARDICKNOWLEDGE_BUFF";
	
	public BardicKnowledge_Buff() {
		
		this.setAnimIcon("actions/rage");				
		this.setSound("HolyCast");
		this.setResource("actions/rage");                  
		this.setName("Bardid Knowledge");
		this.setUnique(true);
		
		BaseInfo b = getTarget();
		
			/*
			int bonus = (b.getValue(StabConstants.BARDCASTER)+1)/2;	
		
			Modifier arcana=new Modifier(StabConstants.KNOWLEDGEARCANA,+bonus);
			Modifier dungeon=new Modifier(StabConstants.KNOWLEDGEDUNGEONEERING,+bonus);
			Modifier engine=new Modifier(StabConstants.KNOWLEDGEENGINEERING,+bonus);
			Modifier geo=new Modifier(StabConstants.KNOWLEDGEGREOGRAPPHY,+bonus);
			Modifier history=new Modifier(StabConstants.KNOWLEDGEHISTORY,+bonus);
			Modifier local=new Modifier(StabConstants.KNOWLEDGELOCAL,+bonus);
			Modifier nature=new Modifier(StabConstants.KNOWLEDGENATURE,+bonus);
			Modifier nobility=new Modifier(StabConstants.KNOWLEDGENOBILITY,+bonus);
			Modifier planes=new Modifier(StabConstants.KNOWLEDGEPLANES,+bonus);
			Modifier religion=new Modifier(StabConstants.KNOWLEDGERELIGION,+bonus);
			
			addTrait(arcana);
			addTrait(dungeon);
			addTrait(engine);
			addTrait(geo);
			addTrait(history);
			addTrait(local);
			addTrait(nature);
			addTrait(nobility);
			addTrait(planes);
			addTrait(religion);;
		*/
		}
}
