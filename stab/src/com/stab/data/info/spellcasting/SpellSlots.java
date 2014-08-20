package com.stab.data.info.spellcasting;

import com.stab.data.actions.player.spells.Spell;
import com.stab.model.info.trait.Rest;
import com.stab.model.info.trait.TargetedTrait;

public class SpellSlots extends TargetedTrait implements Rest {
	
	
	@Override
	public void rest() {
		
	}
	
	public boolean hasSlotFor(Spell spell){
		return true;
	}

	
	public void spendSlot(Spell spell){
		
	}
	
	
	//TODO: mover a Pathfinder utils?
		public int getBonusSpells(String stat,int level) {
				if (level==0)
					return 0;
				int bonus=(getTarget().getValue(stat)-10 )/2;
				if (bonus<0)
					bonus=0;
				int am=0;
				if (bonus>=level)
					am++;
				if (bonus-4>=level)
					am++;
				if (bonus-8>=level)
					am++;
				if (bonus-12>=level)
					am++;
				if (bonus-16>=level)
					am++;
				return am;
			}
	
}
