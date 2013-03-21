package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.PaladinActionSet;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.feat.combat.DazzlingDisplay_Feat;
import com.stab.data.info.feat.combat.WeaponFocus_Feat;


public class PaladinCharacter extends PathfinderCharacter{

	
public static final String ID="PALADIN_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new PaladinActionSet());
		setResource("tokenPaladin");
		setText("Paladin1");
		
		this.setMaxHp(10);
		this.healFully();
		this.fillEnergy();
		
		this.setAttribute(StabConstants.STRENGHT, 17);
		this.setAttribute(StabConstants.DEXTERITY, 12);
		this.setAttribute(StabConstants.CONSTITUTION, 13);
		this.setAttribute(StabConstants.INTELIGENCE, 8);
		this.setAttribute(StabConstants.WISDOM, 10);
		this.setAttribute(StabConstants.CHARISMA, 14);
		
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		this.setAttribute(StabConstants.WILLSAVE, 2);
		
		this.setAttribute(StabConstants.INTIMIDATE, 3);
		this.setAttribute(StabConstants.SENSEMOTIVE, 4);
		
		this.addTrait(new DazzlingDisplay_Feat());
		this.addTrait(new WeaponFocus_Feat(WeaponFactory.LONGSWORD));
		
		this.equip(StabInit.getWeaponFactory().getWeapon("LONGSWORD"), HumanoidGear.BOTHHANDS);
		
		this.equip(StabInit.getArmorFactory().getArmor("BANDED"), HumanoidGear.ARMOR);
		this.equip(StabInit.getWeaponFactory().getWeapon("LONGSWORD"), HumanoidGear.MAINHAND);
		this.equip(StabInit.getArmorFactory().getArmor("HEAVYWOODENSHIELD"), HumanoidGear.OFFHAND);
		
		/* Habilidades especiales
		 * Aura of Good
		 * Detect evil
		 * Smite Evil 1/dia
		 */
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
