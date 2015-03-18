package com.stab.pf.info.monster.bestiary;

import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DamageReduction;
import com.stab.pf.StabConstants;
import com.stab.pf.PfModule;
import com.stab.pf.info.alignment.Evil;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.equipment.WeaponFactory;
import com.stab.pf.info.feat.combat.PowerAttack_Feat;
import com.stab.pf.info.feat.combat.WeaponFocus_Feat;
import com.stab.pf.info.feat.general.ImprovedInitiative_Feat;
import com.stab.pf.info.monster.Undead;
import com.stab.pf.info.monster.ZombieAIParameters;

public class SkeletalChampion extends Undead {

	public static final String ID="SKELETALCHAMPION_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
	
		setResource("skeletalchampion");
		setText("Skeletal Champion");
	
		this.setBloodeffEct("PARTICLE#damage/boneburst");	
		this.setAttribute(StabConstants.XP,600);
		this.setAttribute(StabConstants.STRENGHT,17);
		this.setAttribute(StabConstants.DEXTERITY,13);
		this.setAttribute(StabConstants.INTELLIGENCE,9);
		this.setAttribute(StabConstants.CHARISMA,12);
		this.setAttribute(StabConstants.HITDICENUMBER, 3);
		
		this.addTrait(new DamageReduction(Damage.PIERCING_DAMAGE, 5));
		this.addTrait(new DamageReduction(Damage.IMPACT_DAMAGE, 5));
		
		
		Modifier natural = new Modifier(StabConstants.ARMORDEFENSE,StabConstants.NATURALARMORMOD,+2);
		this.addTrait(natural);

		this.addTrait(new Evil());
		
		this.addTrait(new ImprovedInitiative_Feat());
		this.addTrait(new PowerAttack_Feat());
		this.addTrait(new WeaponFocus_Feat(WeaponFactory.LONGSWORD));
		
		this.equip(PfModule.getWeaponFactory().getWeapon("LONGSWORD"), HumanoidGear.MAINHAND);
		this.equip(PfModule.getArmorFactory().getArmor("BREASTPLATE"), HumanoidGear.ARMOR);
		this.equip(PfModule.getArmorFactory().getArmor("HEAVYSTEELSHIELD"), HumanoidGear.OFFHAND);

		this.setAIParams(new ZombieAIParameters());
		
				
		
		
	}
	
}
