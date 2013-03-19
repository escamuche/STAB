package com.stab.data.info.monster;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DamageReduction;

public class Zombie extends Monster {

	public static final String ID="ZOMBIE_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setMaxHp(12);
		healFully();
		setResource("zombie");
		setText("Zombie");
		setFaction(1);
			
		this.setAttribute(StabConstants.XP,200);
		this.setAttribute(StabConstants.WILLSAVE,+3);
		this.setAttribute(StabConstants.TOHIT,+1);
		this.setAttribute(StabConstants.STRENGHT,17);
		this.setAttribute(StabConstants.DAMAGE,+1);
		
		this.addTrait(new DamageReduction(Damage.PIERCING_DAMAGE, 5));
		this.addTrait(new DamageReduction(Damage.IMPACT_DAMAGE, 5));
		
		
		Modifier natural = new Modifier().createMod(StabConstants.ARMOR,StabConstants.NATURALARMORMOD,+2);
		
		this.addTrait(natural);
		

	//	this.setCurrentAI(new DefaultAIPackage());
		this.setCurrentAI(new ZombieAIPackage());
		
		
		this.setBloodeffEct("PARTICLE#greenblood");
		
		this.equip(StabInit.getWeaponFactory().getWeapon("MEDIUMCLAW"), HumanoidGear.MAINHAND);
	}
	
}
