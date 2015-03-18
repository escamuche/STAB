package com.stab.cards.card;

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


	public void grantUpTo(BaseInfo i,int level){
		for (int f=1;f<=level;f++)
			grant(i,f);
	}
	public void grant(BaseInfo i,int level){
		switch(level){
			case 1: level1(i);break;
			case 2: level2(i);break;
			case 3: level3(i);break;
			case 4: level4(i);break;
			case 5: level5(i);break;
			case 6: level6(i);break;
			case 7: level7(i);break;
			case 8: level8(i);break;
			case 9: level9(i);break;
			case 10: level10(i);break;
		}
	}



	protected void level1(BaseInfo info) {
	}
	protected void level2(BaseInfo info) {
	}
	protected void level3(BaseInfo info) {
	}
	protected void level4(BaseInfo info) {
	}
	protected void level5(BaseInfo info) {
	}
	protected void level6(BaseInfo info) {
	}
	protected void level7(BaseInfo info) {
	}
	protected void level8(BaseInfo info) {
	}
	protected void level9(BaseInfo info) {
	}
	protected void level10(BaseInfo info) {
	}
	
}
