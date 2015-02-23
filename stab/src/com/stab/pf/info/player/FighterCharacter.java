package com.stab.pf.info.player;

import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.actions.FighterActionSet;
import com.stab.pf.actions.feats.PowerAttack;
import com.stab.pf.actions.general.DefendAction;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.feat.combat.PowerAttack_Feat;
import com.stab.pf.info.feat.general.IronWill_Feat;
import com.stab.pf.info.feat.general.Toughness_Feat;


public class FighterCharacter extends PathfinderCharacter{

	
public static final String ID="FIGHTER_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new FighterActionSet());
		setResource("tokenWarrior");
		setText("Warrior1");
		
		this.setMaxHp(10);
		this.healFully();
		this.fillEnergy();
		
		this.setAttribute(StabConstants.STRENGHT, 17);
		this.setAttribute(StabConstants.DEXTERITY, 14);
		this.setAttribute(StabConstants.CONSTITUTION, 12);
		this.setAttribute(StabConstants.INTELLIGENCE, 8);
		this.setAttribute(StabConstants.WISDOM, 13);
		this.setAttribute(StabConstants.CHARISMA, 10);
		
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		
		this.setAttribute(StabConstants.BAB, 1);
		
		this.setAttribute(StabConstants.HEALSKILL, 2);
		this.setAttribute(StabConstants.PERCEPTION, 2);
		this.setAttribute(StabConstants.SURVIVAL, 5);
		
		this.addTrait(new Toughness_Feat());
		this.addTrait(new PowerAttack_Feat());
		this.getActionSet().setAction(PowerAttack.ID, 6);
		this.addTrait(new IronWill_Feat());
		
		this.equip(StabInit.getWeaponFactory().getWeapon("LONGSWORD"), HumanoidGear.MAINHAND);
		this.equip(StabInit.getArmorFactory().getArmor("BREASTPLATE"), HumanoidGear.ARMOR);
		this.equip(StabInit.getArmorFactory().getArmor("HEAVYWOODENSHIELD"), HumanoidGear.OFFHAND);
		
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
