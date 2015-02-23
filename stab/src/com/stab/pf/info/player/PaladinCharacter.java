package com.stab.pf.info.player;

import com.stab.model.info.trait.base.resource.RenewableResource;
import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.actions.PaladinActionSet;
import com.stab.pf.actions.general.DefendAction;
import com.stab.pf.actions.player.abilities.SmiteEvil;
import com.stab.pf.info.alignment.Good;
import com.stab.pf.info.alignment.Lawful;
import com.stab.pf.info.equipment.ArmorFactory;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.equipment.WeaponFactory;
import com.stab.pf.info.feat.combat.DazzlingDisplay_Feat;
import com.stab.pf.info.feat.combat.WeaponFocus_Feat;
import com.stab.pf.info.player.abilities.SmiteEvil_Ability;


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
		this.setAttribute(StabConstants.INTELLIGENCE, 8);
		this.setAttribute(StabConstants.WISDOM, 10);
		this.setAttribute(StabConstants.CHARISMA, 14);
		
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		this.setAttribute(StabConstants.WILLSAVE, 2);
		
		this.setAttribute(StabConstants.INTIMIDATE, 3);
		this.setAttribute(StabConstants.SENSEMOTIVE, 4);
		
		this.addTrait(new DazzlingDisplay_Feat());
		this.addTrait(new WeaponFocus_Feat(WeaponFactory.LONGSWORD));
		
		this.addTrait(new SmiteEvil_Ability());
		this.getActionSet().setAction(SmiteEvil.ID, 6);
		
		this.addTrait(new RenewableResource(SmiteEvil.RESOURCE_ID, 1));
		
		this.equip(StabInit.getArmorFactory().getArmor(ArmorFactory.BANDEDMAIL), HumanoidGear.ARMOR);
		this.equip(StabInit.getWeaponFactory().getWeapon(WeaponFactory.LONGSWORD), HumanoidGear.MAINHAND);
		this.equip(StabInit.getArmorFactory().getArmor(ArmorFactory.HEAVYWOODENSHIELD), HumanoidGear.OFFHAND);
		
		this.addTrait(new Lawful());
		this.addTrait(new Good());
		
		/* Habilidades especiales
		 * Aura of Good					lo mismo que todo, aura centrada que da buff cada turno
		 * Detect evil					esto estaria bien currarse algo original... pero no se me ocurre nada concreto... aun
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
