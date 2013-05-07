package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.RogueActionSet;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;


public class RogueCharacter extends PathfinderCharacter{

	
public static final String ID="ROGUE_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new RogueActionSet());
		setResource("tokenRogue");
		setText("Rogue1");
		
		this.setMaxHp(8);
		this.healFully();
		this.fillEnergy();
		
		this.setAttribute(StabConstants.STRENGHT, 14);
		this.setAttribute(StabConstants.DEXTERITY, 17);
		this.setAttribute(StabConstants.CONSTITUTION, 13);
		this.setAttribute(StabConstants.INTELIGENCE, 10);
		this.setAttribute(StabConstants.WISDOM, 8);
		this.setAttribute(StabConstants.CHARISMA, 12);
		
		this.setAttribute(StabConstants.REFLEXSAVE, 2);
		
		this.setAttribute(StabConstants.ACROBATICS, 7);
		this.setAttribute(StabConstants.CLIMB, 6);
		this.setAttribute(StabConstants.DISABLEDEVICES, 7);
		this.setAttribute(StabConstants.ESCAPEARTIST, 7);
		this.setAttribute(StabConstants.KNOWLEDGELOCAL, 4);
		this.setAttribute(StabConstants.PERCEPTION, 3);
		this.setAttribute(StabConstants.STEALTH, 7);
		this.setAttribute(StabConstants.SLEIGHTOFHAND, 7);
		this.setAttribute(StabConstants.SWIMSKILL, 6);
		
		this.addTrait(new ImprovedInitiative_Feat());
		//this.addTrait(new WeaponFinesse_Feat());
		
		this.equip(StabInit.getWeaponFactory().getWeapon("SHORTSWORD"), HumanoidGear.MAINHAND);
		
		this.equip(StabInit.getArmorFactory().getArmor("STUDDEDLEATHER"), HumanoidGear.ARMOR);

		
		
		
		/* Habilidades especiales
		 * SneakAttack 1d6					hace falta la comprobacion de flanked en attack
		 * Trapfinding						hacen falta trampas, sneak y unas cuantas cosas primero,
		 * 									pero sera una accion de search que haga tiradas de search contra todo lo que tenga en LOS
		 * 
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