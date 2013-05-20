package com.stab.data.info.monster.bestiary;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.monster.Construct;
import com.stab.data.info.monster.ZombieAIParameters;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DamageReduction;
import com.stab.model.info.trait.base.DamageVulnerability;

public class KassenGolem extends Construct {

	public static final String ID="KASSENGOLEM_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
	
		setResource("golemkassen");
		setText("Kassen Golem");
		setFaction(2);
			
		this.setAttribute(StabConstants.XP,800);
		this.setAttribute(StabConstants.STRENGHT,18);
		this.setAttribute(StabConstants.DEXTERITY,10);
		this.setAttribute(StabConstants.WISDOM,8);
		this.setAttribute(StabConstants.HITDICENUMBER, 3);
		
		this.addTrait(new DamageReduction(Damage.PIERCING_DAMAGE, 5));
		this.addTrait(new DamageReduction(Damage.IMPACT_DAMAGE, 5));
		
		this.addTrait(new DamageVulnerability(Damage.FIRE_DAMAGE));
		this.setAttribute(StabConstants.SPELLRESISTANCE, 50);
		
		Modifier natural = new Modifier(StabConstants.ARMORDEFENSE,StabConstants.NATURALARMORMOD,+4);
		this.addTrait(natural);
		
		this.equip(StabInit.getWeaponFactory().getWeapon(WeaponFactory.HEAVYSHIELD), HumanoidGear.MAINHAND);

		ZombieAIParameters ai=new ZombieAIParameters();
		this.setAIParams(new ZombieAIParameters());
		
	}
	
}