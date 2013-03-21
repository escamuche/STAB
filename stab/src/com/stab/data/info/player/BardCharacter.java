package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.BardActionSet;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.SkillFocusPerformWind_Feat;


public class BardCharacter extends PathfinderCharacter{

	
public static final String ID="BARD_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new BardActionSet());
		setResource("tokenBard");
		setText("Bard1");
		
		this.setMaxHp(8);
		this.healFully();
		this.setEp(10);
		this.fillEnergy();
		this.setAttribute(StabConstants.DEXTERITY, 14);
		this.setAttribute(StabConstants.CONSTITUTION, 12);
		this.setAttribute(StabConstants.CHARISMA, 17);
		this.setAttribute(StabConstants.INTELIGENCE, 13);
		this.setAttribute(StabConstants.WISDOM, 8);
		this.setAttribute(StabConstants.REFLEXSAVE, 2);
		this.setAttribute(StabConstants.WILLSAVE, 2);
		this.setAttribute(StabConstants.CASTERLEVEL, 1);
		this.setAttribute(StabConstants.SPELLKNOWN1, 2);
		this.setAttribute(StabConstants.SPELLKNOWN0, 4);
		
		this.addTrait(new SkillFocusPerformWind_Feat());
		//this.addTrait(new WeaponFinesse_Feat());
		
		this.setAttribute(StabConstants.BLUFF, 7);
		this.setAttribute(StabConstants.DIPLOMACY, 7);
		this.setAttribute(StabConstants.PERCEPTION, 5);
		this.setAttribute(StabConstants.PERFORMWIND, 9);
		this.setAttribute(StabConstants.SENSEMOTIVE, 3);
		this.setAttribute(StabConstants.SLEIGHTOFHAND, 6);
		this.setAttribute(StabConstants.STEALTH, 5);
		this.setAttribute(StabConstants.USEMAGICDEVICE, 7);
		
		this.equip(StabInit.getWeaponFactory().getWeapon("RAPIER"), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor("STUDDEDLEATHER"), HumanoidGear.ARMOR);
		
		/* habilidades especiales
		 * Bardic Knowledge
		 * Bardic Performance
		 * Countersong
		 * Distraction
		 * Fascinate
		 * Inspire Courage +1
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
