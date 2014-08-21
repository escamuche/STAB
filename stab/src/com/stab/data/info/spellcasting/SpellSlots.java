package com.stab.data.info.spellcasting;

import com.stab.data.actions.player.spells.Spell;
import com.stab.model.info.trait.Rest;
import com.stab.model.info.trait.TargetedTrait;

public class SpellSlots extends TargetedTrait implements Rest {
	
	int[][] base;
	String stat;
	String casterClass;
	
	
	
	@Override
	public void rest() {
	

	}
	
	
	public void looseSpell(){
		//TODO: en un futuro, perder hechizo de nivel mas alto
		//posiblemente haga falta saber cual es el hechizo de nivel mas alto disponible
	}
	
	
	public boolean hasSlotFor(Spell spell){
		int n=getAvailable(spell.getLevel());
		if (n!=0)
			return true;
		return false;
	}

	
	public void spendSlot(Spell spell){
		
	}
	
	public int getAvailable(int level){
		return -1;
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
			if (base==null)
				return -1;
			if (level==0)
				return -1;
			int i=0;
			int cl= getTarget().getValue(getCasterClass());
			i=getBase()[cl][level];
			
			int b= getBonusSpells(getStat(),level);
			i=i+b;
			
			//TODO: hay algo que añada slots extra? probablemente feats o similar, pensarselo
			
			return i;
		}
	
}
