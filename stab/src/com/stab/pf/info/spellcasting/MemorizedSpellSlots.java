package com.stab.pf.info.spellcasting;

import java.util.ArrayList;

import com.stab.pf.actions.player.spells.Spell;

public class MemorizedSpellSlots extends SpellSlots {

	
	ArrayList<String>[] slots;
	
	ArrayList<String> spontaneous=new ArrayList<String>();
	
	
	public void setSpontaneous(String s){
		spontaneous.add(s);
	}
	
	public boolean isSpontaneous(Spell spell){
		return spontaneous.contains(spell.getAction().getId());
	}
	
	
	
}
