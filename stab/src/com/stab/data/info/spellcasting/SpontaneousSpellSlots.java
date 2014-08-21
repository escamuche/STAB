package com.stab.data.info.spellcasting;

import com.stab.data.actions.player.spells.Spell;

public class SpontaneousSpellSlots extends SpellSlots {

	
	
	
	
	int[] slots = new int[10];


	
	public int getAvailable(int level){
		return slots[level];
	}
	
	@Override
	public void rest() {
	
		for (int f=0;f<9;f++)
			slots[f]=getMax(f);
	}
	
	
	@Override
	public void spendSlot(Spell spell) {
		int lvl=spell.getLevel();
		slots[lvl]=slots[lvl]-1;
		if (slots[lvl]<0)
			slots[lvl]=0;
	}
	

	

}
