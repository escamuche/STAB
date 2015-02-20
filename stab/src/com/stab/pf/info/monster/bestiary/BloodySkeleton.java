package com.stab.pf.info.monster.bestiary;

import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DamageReduction;
import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.info.alignment.Evil;
import com.stab.pf.info.equipment.ArmorFactory;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.feat.general.ImprovedInitiative_Feat;
import com.stab.pf.info.monster.Undead;
import com.stab.pf.info.monster.ZombieAIParameters;
import com.stab.pf.info.monster.abilities.FastHealing;

public class BloodySkeleton extends Undead {

	public static final String ID="BLOODYSKELETON_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		setResource("bloodytoken");
		setText("Esqueleto Sangriento");
	
	
		this.addTrait(new Attribute(StabConstants.STRENGHT,15));
		this.addTrait(new Attribute(StabConstants.DEXTERITY,14));
		this.addTrait(new Attribute(StabConstants.CHARISMA,14));
		this.addTrait(new Attribute(StabConstants.XP,200));
		this.addTrait(new Attribute(StabConstants.HITDICENUMBER, 1));
		
		this.addTrait(new ImprovedInitiative_Feat());
		
		this.addTrait(new Evil());
		
		Modifier armornatural=new Modifier(StabConstants.ARMORDEFENSE,StabConstants.NATURALARMORMOD, +2);
		this.addTrait(armornatural);
		
		this.addTrait(new DamageReduction(Damage.SLASHING_DAMAGE, 5));
		this.addTrait(new DamageReduction(Damage.PIERCING_DAMAGE, 5));
		
		this.addTrait(new FastHealing(1));
		
		this.setAIParams(new ZombieAIParameters());
		
		//ponerle su ataque de 2 garras
		this.equip(StabInit.getArmorFactory().getArmor(ArmorFactory.LIGHTLEATHER), HumanoidGear.ARMOR);
		
		
		
	}
	
}