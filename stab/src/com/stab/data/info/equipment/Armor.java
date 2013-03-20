package com.stab.data.info.equipment;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Equipment;

public class Armor extends Equipment {
	
	public static final int NO_ARMOR=0;
	public static final int LIGHT_ARMOR=1;
	public static final int MEDIUM_ARMOR=2;
	public static final int HEAVY_ARMOR=3;
	public static final int SHIELD=4;
	
	int CA;
	int maxDex;
	int penalty;
	int category;
	int failure;
	
	
	
	
	public Armor(String name,int cA, int maxDex, int penalty, int category,int fail) {
		super();
		setName(name);
		CA = cA;
		failure=fail;
		this.maxDex = maxDex;
		this.penalty = penalty;
		this.category = category;
		if (category==SHIELD){
			this.setSlots(HumanoidGear.OFFHAND);
			this.addTrait(new Modifier(StabConstants.ARMORDEFENSE,StabConstants.SHIELDMOD, CA));
			//this.addTrait(new Modifier(StabConstants.DEXLIMIT,StabConstants.SHIELDMOD, maxDex));
			//ya veremos que hacer con el towershield
			this.addTrait(new Modifier(StabConstants.ARMORCHECKPENALTY,StabConstants.SHIELDMOD, penalty));
			this.addTrait(new Modifier(StabConstants.SPELLFAILURE,StabConstants.SHIELDMOD, failure));
		}
		else{
			this.setSlots(HumanoidGear.ARMOR);
			this.addTrait(new Modifier(StabConstants.ARMORDEFENSE,StabConstants.ARMORMOD, CA));
			this.addTrait(new Modifier(StabConstants.DEXLIMIT,StabConstants.ARMORMOD, maxDex));
			this.addTrait(new Modifier(StabConstants.ARMORCHECKPENALTY,StabConstants.ARMORMOD, penalty));
			this.addTrait(new Modifier(StabConstants.SPELLFAILURE,StabConstants.ARMORMOD, failure));
		}
	
		
	}
	
	
	public int getCA() {
		return CA;
	}
	public void setCA(int cA) {
		CA = cA;
	}
	public int getMaxDex() {
		return maxDex;
	}
	public void setMaxDex(int maxDex) {
		this.maxDex = maxDex;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getFailure() {
		return failure;
	}
	public void setFailure(int failure) {
		this.failure = failure;
	}
	

}
