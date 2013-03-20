package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;
import com.stab.data.info.monster.Undead;
import com.stab.data.info.monster.ZombieAIPackage;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DamageReduction;

public class EsqueletoArquero extends Undead {

	public static final String ID="ESQUELETOARQUERO_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		setResource("skeleto");
		setText("Esqueleto Arquero");
		setFaction(1);
	
		this.addTrait(new Attribute(StabConstants.STRENGHT,15));
		this.addTrait(new Attribute(StabConstants.DEXTERITY,14));
		this.addTrait(new Attribute(StabConstants.XP,135));
		this.addTrait(new Attribute(StabConstants.HITDICENUMBER, 1));
		
		this.addTrait(new ImprovedInitiative_Feat());
		
		Modifier armornatural=Modifier.createMod(StabConstants.ARMORDEFENSE,StabConstants.NATURALARMORMOD, +2);
		this.addTrait(armornatural);
		
		this.addTrait(new DamageReduction(Damage.SLASHING_DAMAGE, 5));
		this.addTrait(new DamageReduction(Damage.PIERCING_DAMAGE, 5));
		

		
	//	this.setCurrentAI(new DefaultAIPackage());
		ZombieAIPackage ai=new ZombieAIPackage();
		ai.setLog(true);
		this.setCurrentAI(ai);
		
		
		this.setBloodeffEct("PARTICLE#greenblood");
		
		
		this.equip(StabInit.getWeaponFactory().getWeapon("LONGBOW"), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor("STUDDEDLEATHER"), HumanoidGear.ARMOR);
		
		
		
	}
	
}
