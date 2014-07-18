package com.stab.data.info;

import com.stab.model.info.BaseInfo;

public abstract class PathfinderCharacterClass extends CharacterClass {
	
	String characterClass;
	String characterSubClass;
	int hidDie;
	
	//int skills_per_level;
	
	//Base attack
	//Saves
	
	
	@Override
	public void levelUpTo(BaseInfo info, int level) {
	
		//Subir el nivel de characterClass y subClass (el arquetipo)
		//añadir HP en base a hitDie
		//añadir skills
		
		
		//Añadir el resto de caracteristicas
		super.levelUpTo(info, level);
	}
	

}
