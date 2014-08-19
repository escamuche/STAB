package com.stab.data.info;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.info.traits.PathfinderAttributeBonus;
import com.stab.model.info.BaseInfo;

public abstract class PathfinderCharacterClass extends CharacterClass {
	
	//Constantes utiles para bab y saves
	List<Integer> EVERY_LEVEL= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
	List<Integer> EVERY_EVEN = Arrays.asList(2,4,6,8,10,11,12,14,16,18,20);  //LA tirada de salvacion primaria suele ir por este, y el bab de wizard tambien
	List<Integer> EVERY_THIRD = Arrays.asList(3,6,9,12,15,18); //Las tiradas de salvacion secundarias suelen ir por este
	List<Integer> CLERICBAB = Arrays.asList(2,3,4,6,7,8,10,11,12,14,15,16,18,19,20); //El infame bab de clerigo
	
	
	String characterClass;
	String characterSubClass;
	int hitDie;
	
	int skills_per_level;
	
	//Base attack
	Collection<Integer>bab;
	//Saves
	Collection<Integer> ref;
	Collection<Integer> fort;
	Collection<Integer> will;
	
	public PathfinderCharacterClass() {
		
		
	}
	
	public void setRef(Collection<Integer> ref) {
		this.ref = ref;
	}
	public void setFort(Collection<Integer> fort) {
		this.fort = fort;
	}
	public void setBab(Collection<Integer> bab) {
		this.bab = bab;
	}
	public void setWill(Collection<Integer> will) {
		this.will = will;
	}
	public void setHitDie(int hitDie) {
		this.hitDie = hitDie;
	}
	public void setSkills_per_level(int skills_per_level) {
		this.skills_per_level = skills_per_level;
	}
	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}
	public void setCharacterSubClass(String characterSubClass) {
		this.characterSubClass = characterSubClass;
	}
	
	
	@Override
	public void levelUp(BaseInfo info, int level) {
	
		//Subir el nivel de characterClass y subClass (el arquetipo)
		
		//añadir HP en base a hitDie
		int hp=0;
		if (StabConstants.USEMAXHPFORPLAYERS){
			hp=hitDie;
			
			
		}else{
			hp=Roll.roll(hitDie);
		}
		info.setMaxHp(info.getMaxHp()+hp);
		//añadimos un bono de con a los hp (cada nivel).  queda ver si es buena opcion o hacer un bono global que cuente el nivel
		info.addTrait(new PathfinderAttributeBonus(StabConstants.MAXHP,StabConstants.CONSTITUTION));
		info.healFully();
		
		//añadir skills
		
		
		//subir basettack
		if (bab.contains(level)){
			//info.
		}
		
		//subir tiradas de salvacion
		
		
		//Añadir el resto de caracteristicas
		super.levelUp(info, level);
	}
	

}
