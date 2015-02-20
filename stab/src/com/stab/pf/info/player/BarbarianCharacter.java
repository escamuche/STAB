package com.stab.pf.info.player;

import com.stab.data.actions.general.DefendAction;
import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.actions.BarbarianActionSet;
import com.stab.pf.actions.feats.PowerAttack;
import com.stab.pf.actions.player.abilities.Rage;
import com.stab.pf.info.alignment.Chaotic;
import com.stab.pf.info.equipment.ArmorFactory;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.equipment.WeaponFactory;
import com.stab.pf.info.feat.combat.IntimidatingProwess_Feat;
import com.stab.pf.info.feat.combat.PowerAttack_Feat;
import com.stab.pf.info.player.abilities.FastMovementBarbarian;
import com.stab.pf.info.player.abilities.Rage_Ability;
import com.stab.pf.info.trait.PathfinderResource;


public class BarbarianCharacter extends PathfinderCharacter{

	
public static final String ID="BARBARIAN_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new BarbarianActionSet());
		setResource("tokenBarbarian");
		setText("Barbarian");
		
		this.setMaxHp(12);
		this.healFully();
		this.fillEnergy();

		this.setAttribute(StabConstants.BAB,1);
		this.setAttribute(StabConstants.STRENGHT, 17);
		this.setAttribute(StabConstants.CONSTITUTION, 14);
		this.setAttribute(StabConstants.DEXTERITY, 10);
		this.setAttribute(StabConstants.WISDOM, 12);
		this.setAttribute(StabConstants.CHARISMA, 8);
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		
		this.addTrait(new PowerAttack_Feat());
		this.getActionSet().setAction(PowerAttack.ID, 5);
		
		this.addTrait(new IntimidatingProwess_Feat());
		
		this.addTrait(new Rage_Ability());
		this.getActionSet().setAction(Rage.ID, 6);
		
		this.addTrait(new FastMovementBarbarian());
		
		this.equip(StabInit.getWeaponFactory().getWeapon(WeaponFactory.GREATAXE), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor(ArmorFactory.BREASTPLATE), HumanoidGear.ARMOR);
		
		this.setAttribute(StabConstants.CLIMB, 5);
		this.setAttribute(StabConstants.KNOWLEDGENATURE, 4);
		this.setAttribute(StabConstants.PERCEPTION, 5);
		this.setAttribute(StabConstants.SURVIVAL, 5);
		this.setAttribute(StabConstants.SWIMSKILL, 5);
		
		this.addTrait(new PathfinderResource(Rage.RESOURCE_ID, 4,StabConstants.CONSTITUTION));
		
		this.addTrait(new Chaotic());
		
	}
	
	
	@Override
	public void setResource(String resource) {
		super.setResource(resource);
	}
	

	
	@Override
	public String getDefaultActionID() {
		return DefendAction.ID;
	}
	
}