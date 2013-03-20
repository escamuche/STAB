package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.monster.Undead;
import com.stab.data.info.monster.ZombieAIPackage;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DamageReduction;

public class Zombie extends Undead {

	public static final String ID="ZOMBIE_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setResource("zombie");
		setText("Zombie");
		setFaction(1);
			
		this.setAttribute(StabConstants.XP,200);
		this.setAttribute(StabConstants.TOHIT,+1);
		this.setAttribute(StabConstants.STRENGHT,17);
		this.setAttribute(StabConstants.HITDICENUMBER, 1);
		
		this.addTrait(new DamageReduction(Damage.PIERCING_DAMAGE, 5));
		this.addTrait(new DamageReduction(Damage.IMPACT_DAMAGE, 5));
		
		
		Modifier natural = new Modifier().createMod(StabConstants.ARMORDEFENSE,StabConstants.NATURALARMORMOD,+2);
		
		this.addTrait(natural);
		

	//	this.setCurrentAI(new DefaultAIPackage());
		this.setCurrentAI(new ZombieAIPackage());
		
		
		this.setBloodeffEct("PARTICLE#greenblood");
		
		this.equip(StabInit.getWeaponFactory().getWeapon("MEDIUMSLAM"), HumanoidGear.BOTHHANDS);
		
		this.rollHp();
	
		
	}
	
}
