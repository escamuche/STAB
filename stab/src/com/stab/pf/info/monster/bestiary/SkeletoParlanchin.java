package com.stab.pf.info.monster.bestiary;

import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DamageReduction;
import com.stab.pf.StabConstants;
import com.stab.pf.PfModule;
import com.stab.pf.info.alignment.Evil;
import com.stab.pf.info.equipment.ArmorFactory;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.equipment.WeaponFactory;
import com.stab.pf.info.feat.general.ImprovedInitiative_Feat;
import com.stab.pf.info.monster.Undead;
import com.stab.pf.info.monster.ZombieAIParameters;

public class SkeletoParlanchin extends Undead {

	public static final String ID="SKELETOPARLANCHIN_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		setResource("skeleto");
		setText("Esqueleto");
		this.setBloodeffEct("PARTICLE#damage/boneburst");
		this.addTrait(new Attribute(StabConstants.STRENGHT,15));
		this.addTrait(new Attribute(StabConstants.DEXTERITY,14));
		this.addTrait(new Attribute(StabConstants.XP,135));
		this.addTrait(new Attribute(StabConstants.HITDICENUMBER, 1));
		
		this.addTrait(new ImprovedInitiative_Feat());
		
		Modifier armornatural=new Modifier(StabConstants.ARMORDEFENSE,StabConstants.NATURALARMORMOD, +2);
		this.addTrait(armornatural);
		
		this.addTrait(new DamageReduction(Damage.SLASHING_DAMAGE, 5));
		this.addTrait(new DamageReduction(Damage.PIERCING_DAMAGE, 5));
		
		this.setAIParams(new ZombieAIParameters());
//		DefaultAIPackage ai = (DefaultAIPackage) this.getCurrentAI();
//		ai.setLog(true);
		
		this.equip(PfModule.getWeaponFactory().getWeapon(WeaponFactory.SCIMITAR), HumanoidGear.MAINHAND);
		this.equip(PfModule.getArmorFactory().getArmor(ArmorFactory.LIGHTLEATHER), HumanoidGear.ARMOR);
		
		this.addTrait(new Evil());
		
	}
	
}
