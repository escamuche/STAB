package com.stab.cards;

import java.util.Hashtable;

import com.stab.model.info.trait.CompoundTrait;


public class CardGear  extends CompoundTrait {
	
	public static final String CLASS="CLASS";
	public static final String FEATURE="FEATURE";
	public static final String ITEM="ITEM";
	public static final String SYNERGY="SYNERGY";
	
	//Subtypes
	public static final String ACCESORY="ACCESORY";
	
	
	static String[] slots= new String[]{CLASS,FEATURE,FEATURE,FEATURE,FEATURE,ITEM,ITEM,ITEM,ITEM,SYNERGY};
	static Hashtable<String,Integer> subtypeRestrictions;
	
	Card[] cards=new Card[slots.length];
	
	 
	static{
		subtypeRestrictions = new Hashtable<String,Integer>();
		
		subtypeRestrictions.put(ACCESORY, 3);
	}
	
	
	
	public Card getCard(int n){
		return cards[n];
	}
	public String getSlot(int n){
		return slots[n];
	}
	
	
	public boolean unequip(int slot){
		
		return true;
	}
	
	public boolean equip(int slot,Card card){
		
		return true;
	}
	
	public boolean canEquip(int slot,Card card){
		if (card.getSubtype()!=null)
			if (!checkRestrictedSubtype(card.getSubtype()))
				return false;
		return canEquip(card);
	}
	
	
	private boolean checkRestrictedSubtype(String subtype) {
		Integer i=subtypeRestrictions.get(subtype);
		if (i!=null)
			return i<=getSubtypeCount(subtype);
		return false;
	}
	
	public int getSubtypeCount(String subtype){
		int count=0;
		for (int n=0;n<cards.length;n++){
			if (cards[n]!=null)
				if (subtype.equals(cards[n].subtype))
					count++;
			
		}
		return count;
	}
	
	public boolean canEquip(Card card){
		return card.canEquip(this.getTarget());
	}
}
