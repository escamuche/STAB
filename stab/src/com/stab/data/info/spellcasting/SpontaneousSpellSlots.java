package com.stab.data.info.spellcasting;

import com.stab.data.actions.player.spells.Spell;

public class SpontaneousSpellSlots extends SpellSlots {

	
	
	int[] slots = new int[10];
	int[][] base;
	String stat;
	String casterClass;
	
	
	@Override
	public void rest() {
		super.rest();
		for (int f=0;f<9;f++)
			slots[f]=getMax(f);
	}
	
	
	
	@Override
	public boolean hasSlotFor(Spell spell) {
		int lvl=spell.getLevel();
		return slots[lvl]>0;
	}
	
	@Override
	public void spendSlot(Spell spell) {
		int lvl=spell.getLevel();
		slots[lvl]=slots[lvl]-1;
		if (slots[lvl]<0)
			slots[lvl]=0;
	}
	

	public void setBase(int[][] base) {
		this.base = base;
	}
	
	public int[][] getBase() {
		return base;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getStat() {
		return stat;
	}
	public void setCasterClass(String casterClass) {
		this.casterClass = casterClass;
	}
	public String getCasterClass() {
		return casterClass;
	}
	

	public int getMax(int level) {
		if (level==0)
			return 9999;
		int i=0;
		int cl= getTarget().getValue(getCasterClass());
		i=getBase()[cl][level];
		
		int b= getBonusSpells(getStat(),level);
		i=i+b;
		
		//TODO: hay algo que añada slots extra? probablemente feats o similar, pensarselo
		
		return i;
	}

}
