package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.feat.combat.PowerAttack_Feat;
import com.stab.data.info.feat.combat.WeaponFocus_Feat;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;
import com.stab.data.info.monster.Undead;
import com.stab.data.info.monster.ZombieAIParameters;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DamageReduction;

public class SkeletalChampion extends Undead {

	public static final String ID="SKELETALCHAMPION_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
	
		setResource("skeletalchampion");
		setText("Skeletal Champion");
		setFaction(2);
			
		this.setAttribute(StabConstants.XP,600);
		this.setAttribute(StabConstants.STRENGHT,17);
		this.setAttribute(StabConstants.DEXTERITY,13);
		this.setAttribute(StabConstants.INTELIGENCE,9);
		this.setAttribute(StabConstants.CHARISMA,12);
		this.setAttribute(StabConstants.HITDICENUMBER, 3);
		
		this.addTrait(new DamageReduction(Damage.PIERCING_DAMAGE, 5));
		this.addTrait(new DamageReduction(Damage.IMPACT_DAMAGE, 5));
		
		
		Modifier natural = new Modifier(StabConstants.ARMORDEFENSE,StabConstants.NATURALARMORMOD,+2);
		this.addTrait(natural);

		
		this.addTrait(new ImprovedInitiative_Feat());
		this.addTrait(new PowerAttack_Feat());
		this.addTrait(new WeaponFocus_Feat(WeaponFactory.LONGSWORD));
		
		this.equip(StabInit.getWeaponFactory().getWeapon("LONGSWORD"), HumanoidGear.MAINHAND);
		this.equip(StabInit.getArmorFactory().getArmor("BREASTPLATE"), HumanoidGear.ARMOR);
		this.equip(StabInit.getArmorFactory().getArmor("HEAVYSTEELSHIELD"), HumanoidGear.OFFHAND);

		ZombieAIParameters ai=new ZombieAIParameters();
		this.setAIParams(new ZombieAIParameters());
		
				
		this.setBloodeffEct("PARTICLE#greenblood");
		
		
	}
	
}
