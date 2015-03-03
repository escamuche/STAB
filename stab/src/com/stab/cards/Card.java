package com.stab.cards;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.EquipableTrait;

public class Card extends EquipableTrait {

	
	public static final int LEVELS=10;
	
	public static final int COMMON=1;
	public static final int UNCOMMON=2;
	public static final int RARE=3;
	
	
	int rarity=COMMON;
	String type=CardGear.FEATURE;
	String subtype=null;
	
	String name;
	String description;
	
	
	String[] descriptions= new String[LEVELS];
	
	
	public Card() {
		
	}
	
	
	
	
	public int getRarity() {
		return rarity;
	}




	public String getType() {
		return type;
	}




	public String getSubtype() {
		return subtype;
	}




	public String getName() {
		return name;
	}




	public String getDescription() {
		return description;
	}




	public String[] getDescriptions() {
		return descriptions;
	}




	public void setRarity(int rarity) {
		this.rarity = rarity;
	}




	public void setType(String type) {
		this.type = type;
	}




	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}




	public void setName(String name) {
		this.name = name;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public void setDescriptions(String[] descriptions) {
		this.descriptions = descriptions;
	}




	public void grant(BaseInfo i,int level){
		
	}
	
	
}
