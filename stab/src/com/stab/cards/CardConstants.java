package com.stab.cards;

import java.lang.reflect.Field;

import com.stab.pf.StabConstants;

public class CardConstants {

	public static final int MAXATTR=5;
	public static final float HPSCALE=1.0f;
	
	
	//Mirarse estas  si usarlas, o no, o hacerlo por defecto o que se yo
	public static final String MAXHP="MAXHP"; 
	public static final String MAXMP="MAXMP";
	
	
	//Attributes
	public static final String FORT="FORT";
	public static final String AGI="AGI";
	public static final String INT="INT";
	public static final String WILL="WILL";
	//Skills
	public static final String LORE="LORE";
	public static final String PERCEPTION="PERCEPTION";
	public static final String TINKER="TINKER";
	public static final String CHARISMA="CHARISMA";
	public static final String NATURE="NATURE";
	public static final String STREETWISE="STREETWISE";
	
	
	
	public static String getString(String table) {
		try{
			Field f=StabConstants.class.getDeclaredField(table);
			return	f.get(null).toString();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("No existe la constante "+table);
		}
		return null;
	}
}
